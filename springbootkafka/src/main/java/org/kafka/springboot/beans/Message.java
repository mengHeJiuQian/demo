package org.kafka.springboot.beans;

import lombok.Data;
import java.util.Date;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/5/17 14:03
 */
@Data
public class Message {

    //id
    private Long id;

    //消息
    private String msg;

    //时间戳
    private Date sendTime;

}
