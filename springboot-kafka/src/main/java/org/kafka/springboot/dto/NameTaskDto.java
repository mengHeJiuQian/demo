package org.kafka.springboot.dto;

import lombok.*;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/16 22:51
 * 版本：1.0
 * 内容描述：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameTaskDto {

    private String batchId;
    // 要生产的信息数量（名字数量）
    private int nameNum;

}
