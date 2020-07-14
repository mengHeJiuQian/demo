package utils.excel.example;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/6/11 15:54
 */
@Data
public class OuterObject {

    private String fqn;
    private String owner;
    private String type;
    private String description;
    private List<Field> fields;
    //private List derivedFields;

}
