package _enum;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/2/22 18:57
 */
enum E {

    GRANT_ONLINE("GRANT_ONLINE","线上渠道发放"),
    GRANT_OFFLINE("GRANT_OFFLINE","线下门店发放"),
    USE_ONLINE("USE_ONLINE","线上渠道使用"),
    USE_OFFLINE("USE_OFFLINE","线下门店使用"),
    ;

    private String code;
    private String name;

    E(String code, String name){
        this.code = code;
        this.name = name;
    }

}

public class TestEnum {

    public static void main(String[] args) {
        System.out.println(E.GRANT_ONLINE.equals("GRANT_ONLINE"));
    }

}
