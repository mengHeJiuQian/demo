package collections.list;

import collections.User;
import java.util.Comparator;

/**
 * @author yang.liu
 * @createtime 2020/11/12 15:41
 * @description
 */
public class UserComparator implements Comparator<User> {

    @Override
    public int compare(User u1, User u2) {
        Integer order1 = Integer.parseInt(u1.getOrder());
        Integer order2 = Integer.parseInt(u2.getOrder());
        if (order1.equals(order2)) {
            Integer ratio1 = Integer.parseInt(u1.getRatio());
            Integer ratio2 = Integer.parseInt(u2.getRatio());
            if (ratio1.equals(ratio2)) {
                return ratio1.compareTo(ratio2);
            }
        }
        return order1.compareTo(order2);
    }

}
