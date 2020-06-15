package book1.spring5guanwang.paramvalidation.validator;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 定义一个富对象（业务嵌套对象），实现自定义验证Validator
 * @Author: sheldon
 * @Create Date: 2019/11/15 10:30
 * @Update Date: 2019/11/15 10:30
 */

@Setter
@Getter
public class Customer {

    /**
     * 名字
     */
    private String firstName;

    /**
     * 姓氏
     */
    private String surName;

    private Address address;

}
