package chapter14;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyMathUtils {

    public static Stream<Integer> primes(int n) {
        return Stream.iterate(2, i -> i+ 1)
                .filter(MyMathUtils::isPrime)
                .limit(n);
    }

    private static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static void main(String[] args) {
        List<Integer> collect = Stream.iterate(2, i -> i++).limit(10).collect(Collectors.toList());
        System.out.println(collect);
    }



}
