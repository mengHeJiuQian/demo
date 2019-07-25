package yang.liu.dubbo.one.api.service;

import yang.liu.dubbo.one.api.request.PushOrderDto;
import yang.liu.dubbo.one.api.response.BaseResponse;

public interface DubboRecordService {

    public BaseResponse pushOrder(PushOrderDto dto);
}
