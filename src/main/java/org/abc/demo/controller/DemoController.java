package org.abc.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.abc.demo.bean.dto.DemoDto;
import org.abc.demo.bean.qo.DemoQo;
import org.abc.demo.bean.vo.DemoVo;
import org.abc.demo.exception.ServerResponse;
import org.abc.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/demo")
@Slf4j
@Api(tags = "测试demo")
public class DemoController {

    @Autowired
    private DemoService demoService;


    @ApiOperation(value = "获取所有手写sql")
    @PostMapping("/getAll")
    @Validated
    public ServerResponse getAll() {
        return ServerResponse.success(demoService.getAll());
    }

    @ApiOperation(value = "查询所有带条件")
    @PostMapping("/selectAll")
    @Validated
    public ServerResponse selectAll(@Valid DemoDto dto) {
        return ServerResponse.success(demoService.selectList(dto));
    }

    @ApiOperation(value = "分页查询所有带条件")
    @PostMapping("/selectPage")
    @Validated
    public ServerResponse selectPage(@Valid DemoQo qo) {
        IPage<DemoVo> result =demoService.selectPage(qo);
        return ServerResponse.successWithPageData(result.getRecords(),result.getTotal());
    }

    @ApiOperation(value = "添加数据")
    @PostMapping("/add")
    @Validated
    public ServerResponse add(@Valid DemoDto dto) {
        demoService.add(dto);
        return ServerResponse.success();
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "string")
    )
    @PostMapping("/remove")
    @Validated
    public ServerResponse remove(@RequestParam @NotBlank(message = "id不能为空") String id) {
        demoService.remove(id);
        return ServerResponse.success();
    }

    @ApiOperation(value = "更新")
    @PostMapping("/updateById")
    @Validated
    public ServerResponse updateById(@Valid DemoDto dto) {
        demoService.updateById(dto);
        return ServerResponse.success();
    }



}
