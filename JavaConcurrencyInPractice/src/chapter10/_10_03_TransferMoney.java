package chapter10;

/**
 * 内容描述：转账会发生死锁的例子，改版后，几乎不会发生死锁，概率非常低。
 * 创建人：yang.liu
 * 创建时间：2019/7/2 16:52
 * 版本：1.0
 */
public class _10_03_TransferMoney {

    private static final Object tieLock = new Object();

    public void transferMoneyMoney(Account fromAccount, Account toAccount, DollarAmount amount) throws Exception {

        class Helper {
            public void transfer() throws Exception {
                if (fromAccount.getBalance().compareTo(amount) < 0) {
                    throw new Exception("钱不够，请充钱");
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }

        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);

        if (fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    new Helper().transfer();
                }
            }
        } else {
            // 极少数情况下会出现这种情况，但是两个账户互相转账，且获取的hash值还一样，几率可想而知，是非常少的。
            // 也可以使用“加时赛”锁，在获取两个Account锁之前，首先获取这个加时赛锁，
            // 从而保证每次只有一个线程以未知的顺序获取这个锁。
            // 注意：如果hash冲突出现概率特别高，那么这种技术可能会成为并发性的瓶颈。
            synchronized (tieLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

}


