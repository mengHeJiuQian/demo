package org.jooq.JooqTest;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.SelectWhereStep;
import org.jooq.domain.Tables;
import org.jooq.domain.tables.records.CustomerRecord;
import org.jooq.impl.DSL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/5/2 11:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:database.properties")
public class DslContextTest {

    private Logger log = LoggerFactory.getLogger(DslContextTest.class);

    @Value("${url}")
    private String url;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    private DSLContext dslContext;

    @Before
    public void before() {
        this.dslContext = getDSLContext();
    }

    @Test
    public void testSelectAll() {
        dslContext.selectFrom(Tables.CUSTOMER).limit(1).stream().forEach(c -> log.info("客户信息：{}。", c.toString()));
    }


    private DSLContext getDSLContext() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return DSL.using(connection, SQLDialect.MYSQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
