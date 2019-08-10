package test;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/10 22:26
 * 版本：1.0
 * 内容描述：4个瓶盖换1瓶酒，要喝150瓶酒，他自己最少多少瓶？
 * 解决思路：买一瓶喝一瓶，存够四个瓶盖就换一瓶。
 */
public class BuyWineAndExchangeWine {

    public static void main(String[] args) {
        System.out.println(drinkWine(150));
    }

    /**
     * @param bottleNum 要喝多少瓶酒
     * @return 最少需要买酒的数量
     */
    public static int drinkWine(int bottleNum) {
        int buy = 0;
        int cap = 0;
        int drink = 0;
        while (true) {
            if (cap != 0 && cap % 4 == 0) {
                cap -= 4;
                drink++;
                cap++;
            }
            if (drink >= bottleNum) {
                return buy;
            }
            buy++;
            drink++;
            cap++;
        }
    }

}
