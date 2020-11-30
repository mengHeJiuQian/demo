import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.collections.CollectionUtils;
import utils.ObjectUtil;

/**
 * 常用测试代码编写在这里，写完即可删除.
 */
public class Test {

    private int[] arr = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {

        }
    }

    /**
     * 只适用于数组长度短的场景，最多不要超过16个长度.
     * @param arr
     */
    public void top(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public int getMin() {
       return arr[9];
    }

}

