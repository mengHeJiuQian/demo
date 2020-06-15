package book1.spring5guanwang.paramvalidation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @Description:
 * @Author: sheldon
 * @Create Date: 2019/11/15 10:37
 * @Update Date: 2019/11/15 10:37
 */
public class PersonValidator implements Validator {

    /**
     * 支持Person.class类实例参数
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    /**
     * 验证target对象逻辑
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        Person person = (Person) target;
        if (person.getAge() < 0) {
            errors.rejectValue("age", "nagetive age");
        } else if (person.getAge() > 10) {
            errors.rejectValue("age", "to darn old");
        }
    }
}
