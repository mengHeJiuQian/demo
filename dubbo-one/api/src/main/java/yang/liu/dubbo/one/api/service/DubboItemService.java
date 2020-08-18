package yang.liu.dubbo.one.api.service;

import yang.liu.dubbo.one.api.response.BaseResponse;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/25 14:40
 * 版本：1.0
 * 内容描述：
 */
public interface DubboItemService {

    BaseResponse listItems();

    BaseResponse listPageItems(Integer pageNo, Integer pageSize);

}
