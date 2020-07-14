package date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 创建人：yang.liu
 * 创建时间：2020/7/10 11:14
 * 版本：1.0
 * 内容描述：
 */
@Getter
@Setter
@ToString
public class Cat {
    private String name;
    private LocalDateTime birth;

    public Cat(String name, LocalDateTime birth) {
        this.name = name;
        this.birth = birth;
    }
}
