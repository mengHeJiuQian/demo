package sql;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @Description:
 * @Author: sheldon
 * @Create Date: 2019/11/5 11:01
 * @Update Date: 2019/11/5 11:01
 */
public class InsertSqlTest {

    /**
     * INSERT INTO `miniprogram3_data_permission`.`t_bq_mp_subscribe_user` (`record_id`, `openid`, `nickname`, `sex`, `city`, `province`, `country`, `language`, `headimgurl_id`, `subscribe`, `subscribe_time`, `unionid`, `remark`, `groupid`, `tag_list`, `subscribe_scene`, `push_status`, `del_flg`, `dept_id`, `update_time`, `update_id`, `create_time`, `create_id`) VALUES ('4', 'ojQZW5wzOlSjCm-vDmPgCuu3ieW4', 'Mr.%E5%88%98', '1', '浦东新区', '上海', '中国', 'zh_CN', '29622', '1', '2019-09-18 14:26:55', 'oPRNt1M-avDGByQcCu8mfbcZDpg8', '', '0', NULL, 'ADD_SCENE_SEARCH', '0', '0', '2', '2019-10-25 16:17:52', NULL, '2019-10-25 16:17:52', NULL);
     */
    @Test
    public void insertTableSubscribeUser() {
        int testNum = 100;
        String prefix = "test";
        StringBuilder insertSql = new StringBuilder("INSERT INTO `miniprogram3_data_permission`.`t_bq_mp_subscribe_user` " +
                "(`openid`, `nickname`, `sex`, `city`, `province`, `country`, `language`, `headimgurl_id`, `subscribe`, `subscribe_time`, `unionid`, `remark`, `groupid`, " +
                "`tag_list`, `subscribe_scene`, `push_status`, `del_flg`, `dept_id`, `update_time`, `update_id`, `create_time`, `create_id`) VALUES");
        for (int i = 1; i <= testNum; i++) {
            String openId = prefix + RandomStringUtils.randomAlphanumeric(24);
            String unionId = prefix + RandomStringUtils.randomAlphanumeric(24);

            insertSql.append(" ('"+ openId +"', 'Mr.%E5%88%98', '1', '浦东新区', '上海', '中国', 'zh_CN', '29622', '1', '2019-09-18 14:26:55', '" + unionId + "', '', '0', NULL, 'ADD_SCENE_SEARCH', '0', '0', '2', '2019-10-25 16:17:52', NULL, '2019-10-25 16:17:52', NULL),");
        }
    }

}
