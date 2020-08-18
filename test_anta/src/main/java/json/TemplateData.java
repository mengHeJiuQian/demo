package json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * 模板数据封装  -- 实体信息.
 */
@Data
public final class TemplateData implements Serializable {

    private static final long serialVersionUID = -9211325405900846359L;

    /**
     * String.
     */
    private String touser;

    /**
     * String.
     */
    @JsonProperty(value = "template_id")
    private String templateId;

    /**
     * TemplateItem.
     */
    private TemplateItem data;

    /**
     * 模板链接地址.
     */
    private String url;

    /**
     * 小程序.
     */
    private MiniProgram miniprogram;

    /**
     * getTemplateData.
     *
     * @return
     */
    public static TemplateData getTemplateData() {
        return new TemplateData();
    }

    public TemplateData() {
        this.data = new TemplateItem();
    }

    /**
     * add.
     *
     * @param key   钥匙
     * @param value 值
     * @param color 颜色代码
     * @return
     */
    public TemplateData add(String key, String value, String color) {
        data.put(key, new Item(value, color));
        return this;
    }

    /**
     * TemplateItem.
     */
    public class TemplateItem extends TreeMap<String, Item> {
        private static final long serialVersionUID = -3728490424738325020L;

        /**
         * TemplateItem.
         */
        public TemplateItem() {
        }

        /**
         * TemplateItem.
         *
         * @param key  模板内容键
         * @param item 对象
         */
        public TemplateItem(String key, Item item) {
            this.put(key, item);
        }
    }

    /**
     * Item.
     */
    @Data
    @AllArgsConstructor
    private class Item {

        /**
         * value.
         */
        private Object value;

        /**
         * color.
         */
        private String color;
    }

    /**
     * 小程序参数.
     */
    @Data
    public static class MiniProgram {
        @JsonProperty(value = "appid")
        private String appId;

        @JsonProperty(value = "pagepath")
        private String pagePath;
    }
}
