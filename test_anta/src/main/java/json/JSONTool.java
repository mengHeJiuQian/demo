package json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * 功能描述：
 * Json处理工具类.
 *
 * @version V1.0
 * @classname: com.metlife.wechat.common.utils.JSONTool.java
 * @copyright Powered By wechat
 * @author: somnus
 * @date: 2019-11-26 14:31:49
 */
@Slf4j
public final class JSONTool {

    /**
     * mapper.
     */
    private static ObjectMapper mapper;
    /**
     * DEFAULT_DF.
     */
    private static DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * HEADER_SCHEMA.
     */
    private static final String HEADER_SCHEMA = "xmlns";

    private JSONTool() {
    }

    static {
        // 解析器支持解析单引号
        getMapperInstance(false).configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 解析器支持解析结束符
        getMapperInstance(false).configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        // jackson反序列化时忽略不需要的字段
        getMapperInstance(false).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 将该标记放在属性上，如果该属性为NULL则不参与序列化
        // 如果放在类上边,那对这个类的全部属性起作用
        // Include.Include.ALWAYS 默认
        // Include.NON_DEFAULT 属性为默认值不序列化
        // Include.NON_EMPTY 属性为 空（“”） 或者为 NULL 都不序列化
        // Include.NON_NULL 属性为NULL 不序列化
        getMapperInstance(false).setSerializationInclusion(JsonInclude.Include.NON_NULL);

    }

    /**
     * toJSON.
     */
    public static String toJSON(Object obj) {
        try {
            return getMapperInstance(false).writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * toObject.
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            getMapperInstance(false).setDateFormat(dateformat);
            return getMapperInstance(false).readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * mapToEntity.
     */
    @SuppressWarnings("rawtypes")
    public static <T> T mapToEntity(Map map, Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    if (field.getModifiers() > 4) {
                        continue;
                    }

                    String name = field.getName();
                    Object val = map.get(name);
                    if (val != null) {
                        BeanUtils.setProperty(t, name, val);
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    /**
     * toMap.
     */
    @SuppressWarnings("rawtypes")
    public static Map toMap(String json) {
        return toObject(json, HashMap.class);
    }

    /**
     * 实体对象转成Map.
     *
     * @param obj 实体对象
     * @return
     */
    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            log.error("【toMap 方法异常】：{}", e);
        }
        return map;
    }

    /**
     * listToJson.
     *
     * @param list 集合
     * @param <T> 泛型
     * @return
     */
    public static <T> String listToJson(List<T> list) {
        return JSON.toJSONString(list);
    }

    /**
     * JavaBean转换成xml ---- [JAXB].
     *
     * @param obj 需要转换的对象
     * @param encoding 编码
     * @return
     */
    /*public static String convertToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            StringWriter out = new StringWriter();
            OutputFormat format = new OutputFormat();
            format.setIndent(true);
            format.setNewlines(true);
            format.setNewLineAfterDeclaration(false);
            XMLWriter writer = new XMLWriter(out, format);

            XMLFilterImpl nsfFilter = new XMLFilterImpl() {
                private boolean ignoreNamespace = false;
                private String rootNamespace = null;
                private boolean isRootElement = true;

                @Override
                public void startDocument() throws SAXException {
                    super.startDocument();
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes atts)
                        throws SAXException {
                    if (this.ignoreNamespace) {
                        uri = "";
                    }
                    if (this.isRootElement) {
                        this.isRootElement = false;
                    } else if (!"".equals(uri) && !localName.contains(HEADER_SCHEMA)) {
                        localName = localName + " xmlns=\"" + uri + "\"";
                    }
                    super.startElement(uri, localName, localName, atts);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (this.ignoreNamespace) {
                        uri = "";
                    }
                    super.endElement(uri, localName, localName);
                }

                @Override
                public void startPrefixMapping(String prefix, String url) throws SAXException {
                    if (this.rootNamespace != null) {
                        url = this.rootNamespace;
                    }
                    if (!this.ignoreNamespace) {
                        if (ConfigPropUtils.get("metlife.eai.eaischema.url").equals(url)) {
                            super.startPrefixMapping("ns0", url);
                        } else {
                            super.startPrefixMapping("", url);
                        }
                    }
                }
            };
            nsfFilter.setContentHandler(writer);
            marshaller.marshal(obj, nsfFilter);
            result = out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }*/

    /**
     * mapToJson.
     *
     * @param map 需要转换的map
     * @return
     */
    public static String mapToJson(Map<?, ?> map) {
        Gson gson = new Gson();
        return gson.toJson(map, Map.class);
    }

    /**
     * xmlToJson.
     *
     * @param xmlString xml格式字符串
     * @return
     */
    /*public static String xmlToJson(String xmlString) {
        return XML.toJSONObject(xmlString).toString();
    }*/

    /**
     * getMapperInstance.
     *
     * @param createNew 是否创建新的实例标识
     * @return
     */
    public static synchronized ObjectMapper getMapperInstance(boolean createNew) {
        if (createNew) {
            return new ObjectMapper();
        } else if (mapper == null) {
            mapper = new ObjectMapper();
        }
        return mapper;
    }

    /**
     * 功能描述:
     * 转换为Json字符串.
     *
     * @methodname: toJSON
     * @params: [obj]
     * @returns: java.lang.String
     * @author: somnus
     * @date: 2019-11-25 18:57:22
     */
    public static String toJson(Object obj) {
        try {
            return getMapperInstance(false).writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 功能描述:
     * json转Map对象.
     *
     * @methodname: toMap
     * @params: [json]
     * @returns: java.util.Map[java.lang.String,java.lang.String]
     * @author: somnus
     * @date: 2019-11-25 19:00:02
     */
    public static Map<String, String> json2Map(String json) {
        try {
            TypeReference<Map<String, String>> ref = new TypeReference<Map<String, String>>() {};
            return getMapperInstance(false).readValue(json, ref);
        } catch (Exception e) {
            log.error("json转Map异常：", e);
        }
        return null;
    }

    /**
     * 将Map的Key转成大写.
     * @param body 原Map
     * @return
     */
    public static Map<String, Object> getUpperMap(Map<String, Object> body) {
        Set<Map.Entry<String, Object>> entries = body.entrySet();
        Map<String, Object> body1 = new HashMap<>();
        entries.forEach(entry -> body1.put(entry.getKey().toUpperCase(), body.get(entry.getKey())));
        return body1;
    }
}
