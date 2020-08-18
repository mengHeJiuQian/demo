package util.excel.example;

import lombok.Data;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/6/11 16:00
 */
@Data
public class Constraint {

    private boolean unique;
    private boolean nullable;
    private String stringLength;

}
