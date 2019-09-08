package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 创建人：yang.liu
 * 创建时间：2019/9/8 15:56
 * 版本：1.0
 * 内容描述：
 */
@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
}
