package core1.chapter05.enums;

import java.util.*;

/**
 * This program demonstrates enumerated types.
 * @version 1.0 2004-05-24
 * @author Cay Horstmann
 */
public class EnumTest {
    public static void main(String[] args) {

        Object[] arr = new Object[2];
        arr[0] = new Object();
        arr[1] = new Object();
        Arrays.sort(arr);

        Class<Integer> integerClass = int.class;
        Class<Integer> integerClass1 = Integer.class;
        System.out.println(integerClass == integerClass1);
        int comp = Size.MEDIUM.compareTo(Size.SMALL);
        System.out.println(comp);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE)
            System.out.println("Good job--you paid attention to the _.");
    }
}

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    private String abbreviation;

    private Size(String abbreviation) { this.abbreviation = abbreviation; }

    public String getAbbreviation() { return abbreviation; }
}
