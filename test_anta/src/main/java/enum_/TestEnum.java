package enum_;

import lombok.extern.slf4j.Slf4j;

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

@Slf4j
public class TestEnum {

    public static void main(String[] args) {
        String projectId = "10000";
        projectId += projectId.substring(projectId.length()-1);
        System.out.println(projectId);
        System.out.println(Long.valueOf(100000));

        int i = 1;
        log.info("开启柔性事物：{}", i == 1 ? true : false);
    }

}
