package aspectj.testredislock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@ApiModel(value = "CreateBenefitRequest")
public class CreateBenefitRequest {
    @NotNull(message = "项目ID不能为空")
    @ApiModelProperty(value = "权益项目ID:必填",required = true,dataType = "number")
    private Long projectId = 111L;
    @NotEmpty(message = "品牌不能为空")
    @ApiModelProperty(value = "品牌:anta, fila:必填",required = true,dataType = "string")
    private String brand = "anta";
    @NotEmpty(message = "会员ID不能为空")
    @ApiModelProperty(value = "会员ID:必填",required = true, dataType = "string")
    private String userId = "user123";

    @NotEmpty(message = "会员ID不能为空")
    @ApiModelProperty(value = "会员ID:必填",required = true, dataType = "string")
    private String grantInstance = "=user123=";

    @NotEmpty(message = "会员名称不能为空")
    @ApiModelProperty(value = "会员名称:必填",required = true, dataType = "string")
    private String userName;

    @ApiModelProperty(value = "手机号码:可选",dataType = "string")
    private String mobile;
    @NotEmpty(message = "发放渠道id不能为空")
    @ApiModelProperty(value = "发放渠道code, OFFICIAL_SITE:官网 ,POS:POS ,MALL:积分商城 ,ACTIVE_MARKETING:主动营销, LOYALTY:忠诚度, 门店CODE, :必填", dataType = "string")
    private String grantChannelId;
    @NotEmpty(message = "发放渠道名称不能为空")
    @ApiModelProperty(value = "发放渠道名称, 主动营销,官网POS,忠诚度,门店名称 :必填", dataType = "string")
    private String grantChannelName;

    @ApiModelProperty(value = "微信ID:可选",dataType = "string")
    private String openId;

    @ApiModelProperty(value = "会员卡号:可选",dataType = "string")
    private String userCardNo;

    @ApiModelProperty(value ="请求唯一ID,用于日志跟踪:可选",dataType = "string")
    private String seqNo;


}
