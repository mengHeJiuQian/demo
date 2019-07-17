package number;

import java.text.DecimalFormat;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2018/12/23 14:42
 */
public class DecimalFormatTest {

    public void format(String pattern,double value){
        DecimalFormat df=new DecimalFormat(pattern);
        String str=df.format(value);
        System.out.println("使用" + pattern+ "\t格式化数字"+value+"：\t" + str);
    }
    public static void main(String[] args) {
        DecimalFormatTest demo=new DecimalFormatTest();
        demo.format("###,###.###", 111222.34567);
        demo.format("000,000.000", 11222.34567);
        demo.format("###,###.###$", 111222.34567);
        demo.format("000,000.000￥", 11222.34567);
        demo.format("##.###%", 0.345678);        // 使用百分数形式
        demo.format("00.###%", 0.0345678);        // 使用百分数形式
        demo.format("###.###\u2030", 0.345678);    // 使用千分数形式

    }

}
