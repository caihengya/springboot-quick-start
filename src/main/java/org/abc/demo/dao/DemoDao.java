package org.abc.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.abc.demo.bean.entity.Demo;
import org.abc.demo.bean.vo.DemoVo;

import java.util.List;

public interface DemoDao extends BaseMapper<Demo> {

    List<DemoVo> getAll();
}
