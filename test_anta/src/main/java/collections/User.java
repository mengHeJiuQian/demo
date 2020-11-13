package collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yang.liu
 * @createtime 2020/11/12 16:29
 * @description
 */
@Getter
@Setter
@AllArgsConstructor
public class User implements Comparable<User> {

    // 受益顺序
    private String order;

    // 受益比例
    private String ratio;

    // 受益人姓名
    private String name;

    @Override
    public int compareTo(User o) {
        String order1 = o.getOrder();
        String order2 = this.order;
        if (order1.equals(order2)) {
            String ratio1 = o.getRatio();
            String ratio2 = this.ratio;
            return ratio2.compareTo(ratio1);
        }
        return order2.compareTo(order1);
    }

    /**
     * 从大到小
     * @param o
     * @return
     */
    /*@Override
    public int compareTo(User o) {
        Integer order1 = Integer.parseInt(o.getOrder());
        Integer order2 = Integer.parseInt(this.order);
        if (order1.equals(order2)) {
            Integer ratio1 = Integer.parseInt(o.getRatio());
            Integer ratio2 = Integer.parseInt(this.ratio);
            return ratio2.compareTo(ratio1);
        }
        return order2.compareTo(order1);
    }*/
}
