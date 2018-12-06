package aspectj;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/10/25 10:37
 */
@Component
public class TaotaoMall {

    @TransactionAnno(transactionName = "购买书籍")
    public String buyBooks(String[] bookNames) {

        System.out.println("购买了这些书籍：" + Arrays.toString(bookNames));
        return Arrays.toString(bookNames);

    }

}
