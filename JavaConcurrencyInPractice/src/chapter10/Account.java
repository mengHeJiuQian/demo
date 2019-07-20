package chapter10;

/**
 * 内容描述：
 * 创建人：yang.liu
 * 创建时间：2019/7/2 17:13
 * 版本：1.0
 */
public class Account {
    private DollarAmount balance;

    public DollarAmount getBalance() {
        return balance;
    }

    public void setBalance(DollarAmount balance) {
        this.balance = balance;
    }

    // 借记
    public void debit(DollarAmount amount) {

    }
    // 存入
    public void credit(DollarAmount amount) {

    }
}
