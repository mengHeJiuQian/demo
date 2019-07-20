package chapter10;

import java.util.Comparator;

/**
 * 内容描述：转账会发生死锁的例子
 * 创建人：yang.liu
 * 创建时间：2019/7/2 16:52
 * 版本：1.0
 */
public class _10_02_TransferMoneyDeadlock {

    public void transferMoneyMoney(Account fromAccount, Account toAccount, DollarAmount amount) throws Exception {
        // 可能会发生死锁！！！
        synchronized (fromAccount) {
            synchronized (toAccount) {
                if (fromAccount.getBalance().compareTo(amount) < 0) {
                    throw new Exception("钱不够，请充钱");
                } else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
    }

}
