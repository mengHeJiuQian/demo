package util.excel.example;

import lombok.Data;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/6/11 16:03
 */
@Data
public class DerivedField {

    private String name;
    private String title;
    private String description;
    private String category;
    private FieldType fieldType;
    private String expr;
}
