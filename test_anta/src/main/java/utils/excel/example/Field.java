package utils.excel.example;

import lombok.Data;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/6/11 15:58
 */
@Data
public class Field {

    private String name;
    private Constraint constraint;
    private FieldType fieldType;
    private String description;
}
