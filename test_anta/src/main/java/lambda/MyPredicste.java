package lambda;

@FunctionalInterface
public interface MyPredicste {

    boolean test();

    static void doing() {
        System.out.println("2222");
    }

    default String helloWorld() {
        return "Hello world";
    }
}
