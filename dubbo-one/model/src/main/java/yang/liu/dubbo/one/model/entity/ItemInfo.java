package yang.liu.dubbo.one.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class ItemInfo implements Serializable{
    private Integer id;

    private String code;

    private String name;

    private BigDecimal price;

    private Integer isActive;

    private Date createTime;

    private Date updateTime;

}