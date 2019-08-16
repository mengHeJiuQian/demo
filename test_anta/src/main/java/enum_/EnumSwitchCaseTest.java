package enum_;

import org.junit.jupiter.api.Test;

/**
 * 测试switch case的枚举使用方式
 */
public class EnumSwitchCaseTest {

    enum CardType {
        CASH, DISCOUNT, GIFT, GENERAL_COUPON
    }

    @Test
    public void testEnumSwitchCase() {
        CardType cardType = CardType.GIFT;
        switch (cardType) {
            case CASH:
                System.out.println("CASH");
                break;
            case DISCOUNT:
                System.out.println("DISCOUNT");
                break;
            case GIFT:
                System.out.println("GIFT");
                break;
            case GENERAL_COUPON:
                System.out.println("GENERAL_COUPON");
                break;
            default:
                System.out.println("error");
        }
    }

}

