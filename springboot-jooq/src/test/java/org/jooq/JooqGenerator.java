package org.jooq;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;
import org.jooq.meta.jaxb.Configuration;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/5/2 10:33
 */
public class JooqGenerator {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("com.mysql.cj.jdbc.Driver")
                        .withUrl("jdbc:mysql://localhost:3306/springboot_demo?characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Shanghai")
                        .withUser("root")
                        .withPassword("123456"))
                .withGenerator(new Generator()
                        .withDatabase(new Database()
                                .withName("org.jooq.meta.mysql.MySQLDatabase")
                                .withIncludes(".*")
                                .withInputSchema("springboot_demo"))
                        .withTarget(new Target()
                                .withPackageName("org.jooq.domain")
                                .withDirectory("./src/main/java"))); //生成的文件在项目文件夹路径

        GenerationTool.generate(conf);
    }
}
