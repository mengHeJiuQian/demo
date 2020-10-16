package number;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.junit.Test;

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
        demo.format("#.##", 0.300111);        // 使用百分数形式
        demo.format("#.##%", 0.300000);        // 使用百分数形式
        demo.format("0.00", 0.300111);        // 使用百分数形式
        demo.format("0.00%", 0.300111);        // 使用百分数形式
        demo.format("##.###%", 0.345678);        // 使用百分数形式
        demo.format("00.###%", 0.030000);        // 使用百分数形式
        demo.format("###.###\u2030", 0.345678);    // 使用千分数形式

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(0.300111));
        DecimalFormat df2 = new DecimalFormat("0.00");
        System.out.println(df2.format(0.300111));


    }

    @Test
    public void testDecimalFormat() {
        System.out.println(66F / 101F);
        System.out.println(61D / 101D);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String format = decimalFormat.format(66D / 101D);
        System.out.println(format);
    }

}
