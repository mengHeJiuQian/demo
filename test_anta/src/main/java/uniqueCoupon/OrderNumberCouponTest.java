package uniqueCoupon;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/3/7 18:10
 */
public class OrderNumberCouponTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            System.out.println(gen("99999", i));
        }
    }

    public static String gen(String projectId, int seq) {
        StringBuffer coupon = new StringBuffer(projectId);

        String seqStr = String.valueOf(seq);
        for (int i = 0; i < 13 - projectId.length() - seqStr.length(); i++) {
            coupon.append(0);
        }
        coupon.append(seqStr);
        return coupon.toString();
    }
}
