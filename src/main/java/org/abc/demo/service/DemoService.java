package org.abc.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.abc.demo.bean.dto.DemoDto;
import org.abc.demo.bean.qo.DemoQo;
import org.abc.demo.bean.vo.DemoVo;

import java.util.List;

public interface DemoService {

    /**
     * 查询所有
     * @return
     */
    List<DemoVo> getAll();

    /**
     * 根据条件查询
     * @param dto
     * @return
     */
    List<DemoVo> selectList(DemoDto dto);

    /**
     * 根据条件分页查询
     * @param qo
     * @return
     */
    IPage<DemoVo> selectPage(DemoQo qo);

    /**
     * 添加数据
     * @param dto
     */
    void add(DemoDto dto);

    /**
     * 删除
     * @param id
     */
    void remove(String id);

    /**
     * 更新数据
     * @param dto
     */
    void updateById(DemoDto dto);
}
