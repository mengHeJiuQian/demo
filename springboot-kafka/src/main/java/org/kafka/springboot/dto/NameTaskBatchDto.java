package org.kafka.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/17 9:06
 * 版本：1.0
 * 内容描述：任务分批消费，每一批又被传入kafka，作为生产的消息数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameTaskBatchDto {

    // 批次号
    private String batchId;
    // 需要操作的实例
    private List<String> nameList;

}
