package book1.spring5guanwang.paramvalidation.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @Description: SpEL支持一系列广泛的特性，例如方法调用，访问属性，调用构造函数等。
 * @Author: sheldon
 * @Create Date: 2019/11/15 13:43
 * @Update Date: 2019/11/15 13:43
 */
public class SpELDemo {

    public static void main(String[] args) {
        int length = "Hello World".getBytes().length;

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp1 = parser.parseExpression("'Hello World'");
        Expression exp2 = parser.parseExpression("'Hello World'.concat('!')");
        Expression exp3 = parser.parseExpression("'Hello World'.bytes.length");
        Expression exp4 = parser.parseExpression("new String('hello world').toUpperCase()");
        Object value = exp4.getValue();
        System.out.println("value = " + value);
    }
}
