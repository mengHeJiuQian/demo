import com.alibaba.fastjson.JSON;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import utils.ObjectUtil;

/**
 * 常用测试代码编写在这里，写完即可删除.
 */
public class Test {

    // [{"address":"123","name":"yang.liu"},{"address":"123","name":"yang.liu"}]

    public static void main(String[] args) {
        List<User> oldList = new ArrayList<>();
        User u1 = User.init();
        u1.setName("");
        u1.setAddress("123");

        oldList.add(u1);

        if (CollectionUtils.isNotEmpty(oldList)) {
            oldList.stream().sorted(Comparator.comparing(User::getName));
        }

        List<User> newList = new ArrayList<>();
        User u2 = User.init();
        u2.setAddress("123");
        newList.add(u2);

        if (CollectionUtils.isNotEmpty(newList)) {
            newList.stream().sorted(Comparator.comparing(User::getName));
        }

        System.out.println(JSON.toJSONString(oldList));
        System.out.println(JSON.toJSONString(newList));
        System.out.println(ObjectUtil.isSamePropertyValue(oldList, newList));

        User u3 = new User();
        u3.setName("aaa");
        u3.setAddress("aaa");

        User u4 = new User();
        u4.setAge("");

        ObjectUtil.copyPropertiesWithValue(u3, u4);

        System.out.println(JSON.toJSONString(u3));
        System.out.println(JSON.toJSONString(u4));
    }

}


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
class User {

    /**
     * 主键.
     */
    // private Integer id;

    /**
     * 记录号.
     */
    // private String recId;

    /**
     * 客户唯一编号.
     */
    private String customerId;

    /**
     * 保单号.
     */
    private String policyNo;

    /**
     * 身故受益人姓名.
     */
    private String name;

    /**
     * 受益人与被保险人的关系.
     */
    private String relationShip;

    /**
     * 出生日期.
     */
    private String birthday;

    /**
     * 性别 男1 女2.
     */
    private String gender;

    /**
     * 证件类型.
     */
    private String certiType;

    /**
     * 证件号码.
     */
    private String certiId;

    /**
     * 证件有效期.
     */
    private String certiExpiryDate;

    /**
     * 国籍.
     */
    private String nationality;

    /**
     * 国籍.
     */
    // private String nationalityName;

    /**
     * 手机号码.
     */
    private String mobile;

    /**
     * 居住地址.
     */
    private String address;

    /**
     * 邮政编码.
     */
    private String postCode;

    /** 职业名称. */
    private String jobCode;

    /** 职业名称. */
    private String jobCodeName;

    /** 年龄. */
    private String age;

    /** 邮箱. */
    private String email;

    /** 证件有效期类型(0:终身有效,1:非终身有效). */
    private String idExpireDateType;

    /**
     * 是否是法定受益人0:否,1:是.
     */
    private String isstatutoryBeneficiary;

    /**
     * 受益顺位.
     */
    private String rank;

    /**
     * 受益比例.
     */
    private String ratio;

    /**
     * 状态.
     */
    // private String status;

    /**
     * 是否ocr Y是N否.
     */
    //private String isOcr;

    /**
     * ocr识别失败remark.
     */
    //private String ocrFailRemark;

    /**
     * 操作类型1.新增 2.删除.
     */
    //private String newAdd;

    /**
     * 是否删除0:false,1:true.
     */
    //private int isDeleted;


    public static User init() {
        User u = new User();
        u.customerId = "";
        u.policyNo = "";
        u.name = "";
        u.relationShip = "";
        u.birthday = "";
        u.gender = "";
        u.certiType = "";
        u.certiId = "";
        u.certiExpiryDate = "";
        u.nationality = "";
        u.mobile = "";
        u.address = "";
        u.postCode = "";
        u.jobCode = "";
        u.jobCodeName = "";
        u.age = "";
        u.email = "";
        u.idExpireDateType = "";
        u.isstatutoryBeneficiary = "";
        u.rank = "";
        u.ratio = "";
        return u;
    }
}
// 1603173717271
// 1382694957
// 1595470508000
// 2147483647