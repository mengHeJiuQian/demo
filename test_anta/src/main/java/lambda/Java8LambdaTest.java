package lambda;

import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/8/29 11:16
 */
public class Java8LambdaTest {
    public static void main(String[] args) {
//        testMap();
        testFilter();

    }

    // Java8中的“方法引用”可以用“双冒号”代替，“双冒号”不能对静态类的方法使用
    public static void testMap() {
        List<OrgRecord> orgRecordList = new ArrayList<>();
        Function<Object, Integer> hashCode = Object::hashCode;
        orgRecordList.stream().map(Objects::hashCode);
    }

    public static void addAge(OrgRecord orgRecord) {
        orgRecord.setAge(orgRecord.getAge() + 100);
    }

    public static void testFilter() {
        List<OrgRecord> orgRecordList = new ArrayList<>();
        orgRecordList.add(new OrgRecord("aa", 11));
        orgRecordList.add(new OrgRecord("bb", 22));
        orgRecordList.add(new OrgRecord("cc", 33));
        orgRecordList.add(new OrgRecord("dd", 44));
        orgRecordList.add(new OrgRecord("ee", 55));

        // filter 对集合元素进行条件过滤
        System.out.println(orgRecordList);
        List<OrgRecord> collect = orgRecordList.stream()
                .filter(orgRecord -> {
                    return orgRecord.getAge() > 30;
                })
                .collect(Collectors.toList());

        System.out.println(collect);

        /*List<OrgRecord> allOrgRecords = new ArrayList<>();
        List<OrgRecord> result = allOrgRecords.stream()
                .filter(orgRecord -> {
                    return (type == null || type.equals(orgRecord.getType())) ||
                            orgContainsName(orgRecord, name) ||
                            orgContainsCode(orgRecord, code) ||
                            orgContainsKw(orgRecord, kw) ||
                            (parentId == null || parentId.equals(orgRecord.getParentId()));
                }).collect(Collectors.toList());*/
    }

    static class OrgRecord {
        private String name;
        private int age;

        @Override
        public String toString() {
            return "OrgRecord{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public OrgRecord(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
