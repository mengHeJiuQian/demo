package chapter16;

import util.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/7 11:40
 * 版本：1.0
 * 内容描述：不可变对象的初始化安全性
 */
@ThreadSafe
public class SafeStates {

    private final Map<String, String> states;

    public SafeStates() {
        this.states = new HashMap<>();
        states.put("yang.liu", "1 year");
    }

    public String getAbbreviation(String s) {
        return states.get(s);
    }
}
