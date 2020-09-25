package json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述：
 * 微信模板消息封装  -- 实体信息.
 *
 * @version V1.0
 * @classname: com.metlife.wechat.modules.model.wx.TemplateData.java
 * @copyright Powered By wechat
 * @author: somnus
 * @date: 2019-12-10 19:04:29
 */
@Data
public final class TemplateData {

    /** 接收者标识. */
    private String touser;

    /** 模板Id. */
    @JsonProperty(value = "template_id")
    private String templateId;

    /** 模板对象. */
    private TemplateItem data;

    /** 点击模板消息跳转链接. */
    private String url;

    /**
     * 小程序.
     */
    private MiniProgram miniprogram;

    /**
     * 功能描述:
     * 获取模板数据.
     *
     * @methodname: getTemplateData
     * @params: []
     * @returns: com.metlife.wechat.modules.model.wx.TemplateData
     * @author: somnus
     * @date: 2019-12-10 19:05:59
     */
    public static TemplateData getTemplateData() {
        return new TemplateData();
    }

    TemplateData() {
        this.data = new TemplateItem();
    }

    /**
     * add.
     *
     * @param key   键
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
    public static class TemplateItem extends TreeMap<String, Item> {

        /**
         * TemplateItem.
         */
        private TemplateItem() {
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
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Item {

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
