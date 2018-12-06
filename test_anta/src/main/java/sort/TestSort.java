package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/12 16:15
 */
public class TestSort {
    public static void main(String[] args) {
        Student s1 = new Student("fenxiaoshang", "老一");
        Student s2 = new Student("2004d", "老二");
        Student s3 = new Student("经销商", "老仨");
        Student s4 = new Student("q7", "老四");
        Student s5 = new Student("q8", "老四");
        Student s6 = new Student("A012", "老四");
        Student s7 = new Student("A082", "老四");
        Student s8 = new Student("A030", "老四");
        Student s9 = new Student("12", "老四");
        Student s10 = new Student("12", "老四");

        List<Student> sList = new ArrayList<>();
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        sList.add(s4);
        sList.add(s5);
        sList.add(s6);
        sList.add(s7);
        sList.add(s8);
        sList.add(s9);
        sList.add(s10);

        System.out.println(sList);
        sList.sort(Comparator.comparing(Student::getId));
        System.out.println(sList);


    }
}
