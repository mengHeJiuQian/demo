package json;

/**
 * @author yang.liu
 * @createtime 2020/10/22 9:50
 * @description
 */
public class User {

    private String nickName;
    private Integer isSubscription;

    public User(String nickName, Integer isSubscription) {
        this.nickName = nickName;
        this.isSubscription = isSubscription;
    }

    public String getNickName() {
        System.out.println("getNickName");
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getIsSubscription() {
        System.out.println("getIsSubscription");
        return isSubscription;
    }

    public void setIsSubscription(Integer isSubscription) {
        this.isSubscription = isSubscription;
    }
}
