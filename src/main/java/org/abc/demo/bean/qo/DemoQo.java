package org.abc.demo.bean.qo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 查询入参
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemoQo {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型
     */
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空")
    private String demoName;

    @ApiModelProperty(value = "密码")
    private String demoPassword;

    @NotNull(message = "当前页不能为空")
    @ApiModelProperty(value = "当前页", required = true)
    private Integer page;

    @NotNull(message = "每页显示条数不能为空")
    @ApiModelProperty(value = "每页显示条数", required = true)
    private Integer limit;
}