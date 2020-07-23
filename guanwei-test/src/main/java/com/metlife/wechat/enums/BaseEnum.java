package com.metlife.wechat.enums;

import java.io.Serializable;

/**
 * BaseEnum.
 * @param <T> 泛型类型
 */
public interface BaseEnum<T> extends Serializable {

    /** getCode. */
    T getCode();

    /** getDesc. */
    String getDesc();
}
