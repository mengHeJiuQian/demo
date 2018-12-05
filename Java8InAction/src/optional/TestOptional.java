package optional;

import java.util.Optional;

public class TestOptional {

    public static void main(String[] args) {
        // 1.声明一个空的Optional对象
        Optional<Object> optionalObj1 = Optional.empty();

        // 2.依据一个非空值创建Optional
        Object obj2 = null;
        // Optional<Object> optionalObj2 = Optional.of(obj2); // 会报 NullPointerException

        // 3.可接受null的Optional
        Object obj3 = null;
        Optional<Object> optionalObj3 = Optional.ofNullable(obj3);
    }

}
