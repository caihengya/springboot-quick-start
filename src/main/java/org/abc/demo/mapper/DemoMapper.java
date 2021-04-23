package org.abc.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.abc.demo.bean.dto.DemoDto;
import org.abc.demo.bean.entity.Demo;
import org.abc.demo.bean.vo.DemoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoMapper extends BaseMapper<Demo> {
    List<DemoVo> getAll(DemoDto demoDto);
}