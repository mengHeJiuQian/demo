package yang.liu.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yang.liu.dubbo.one.api.enums.StatusCode;
import yang.liu.dubbo.one.api.response.BaseResponse;
import yang.liu.dubbo.one.api.service.DubboItemService;
import yang.liu.dubbo.one.model.entity.ItemInfo;
import yang.liu.dubbo.one.model.mapper.ItemInfoMapper;

import javax.ws.rs.Path;
import java.util.List;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/25 14:42
 * 版本：1.0
 * 内容描述：
 */
@Path("dubboOne")
@Service(protocol = {"dubbo", "rest"}, validation = "true", version = "1.0", timeout = 3000)
public class DubboItemServiceImpl implements DubboItemService {

    public static final Logger log = LoggerFactory.getLogger(DubboItemServiceImpl.class);

    public static final Gson gson = new Gson();

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Override
    public BaseResponse listItems() {
        BaseResponse<List> response;

        try {
            List<ItemInfo> items = itemInfoMapper.selectAll();
            log.info("查询结果{}", gson.toJson(items));
            response = new BaseResponse(StatusCode.SUCCESS, items);
        } catch (Exception e) {
            log.error("商品列表查询失败", e.fillInStackTrace());
            response = new BaseResponse(StatusCode.FAILURE);
        }
        return response;
    }

    @Path("item/page/list")
    @Override
    public BaseResponse listPageItems(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        BaseResponse response = new BaseResponse<>(StatusCode.SUCCESS);

        try {
            PageHelper.startPage(pageNo, pageSize);
            PageInfo info = new PageInfo<ItemInfo>(itemInfoMapper.selectAll());
            response.setData(info);
        } catch (Exception e) {
            log.error("商品分页查询失败", e.fillInStackTrace());
            response = new BaseResponse(StatusCode.FAILURE);
        }
        return response;
    }

}
