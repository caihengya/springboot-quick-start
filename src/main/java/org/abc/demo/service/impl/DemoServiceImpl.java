package org.abc.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.abc.demo.bean.dto.DemoDto;
import org.abc.demo.bean.entity.Demo;
import org.abc.demo.bean.qo.DemoQo;
import org.abc.demo.bean.vo.DemoVo;
import org.abc.demo.dao.DemoDao;
import org.abc.demo.exception.BaseException;
import org.abc.demo.exception.ReturnCodeType;
import org.abc.demo.service.DemoService;
import org.abc.demo.util.BeanCopyUtils;
import org.abc.demo.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoDao demoDao;

    @Override
    public List<DemoVo> getAll() {
        return demoDao.getAll();
    }


    @Override
    public List<DemoVo> selectList(DemoDto dto) {
        LambdaQueryWrapper<Demo> query = new LambdaQueryWrapper<Demo>()
                .like(Demo::getDemoName, dto.getDemoName());

        if (!StringUtils.isBlank(dto.getDemoPassword())) {
            query.like(Demo::getDemoPassword, dto.getDemoPassword());
        }
        List<Demo> demos = demoDao.selectList(query);
        return BeanCopyUtils.copyBeanList(demos, DemoVo.class);
    }

    @Override
    public IPage<DemoVo> selectPage(DemoQo qo) {
        int page = qo.getPage();
        int limit = qo.getLimit();

        LambdaQueryWrapper<Demo> query = new LambdaQueryWrapper<Demo>()
                .like(Demo::getDemoName, qo.getDemoName());

        if (!StringUtils.isBlank(qo.getDemoPassword())) {
            query.like(Demo::getDemoPassword, qo.getDemoPassword());
        }


        IPage<Demo> demoPage = demoDao.selectPage(new Page<>(page, limit), query);
        return  demoPage .convert(demo -> ConvertUtils.beanCopy(demo, DemoVo.class));

    }

    @Override
    public void add(DemoDto dto) {
        Demo demoBuilder = Demo.builder().demoName(dto.getDemoName()).demoPassword(dto.getDemoPassword()).build();
        if (demoDao.insert(demoBuilder) <= 0) {
            throw new BaseException(ReturnCodeType.INSERT_ERROR);
        }
    }

    @Override
    public void remove(String id) {
        if (demoDao.deleteById(id) <= 0) {
            throw new BaseException(ReturnCodeType.DELETE_ERROR);
        }
    }

    @Override
    public void updateById(DemoDto dto) {
        Demo demoBuilder = Demo.builder().id(dto.getId()).demoName(dto.getDemoName()).demoPassword(dto.getDemoPassword()).build();
        int updateNum = demoDao.update(demoBuilder, new LambdaQueryWrapper<Demo>()
                .eq(Demo::getId, dto.getId())
        );
        if (updateNum <= 0) {
            throw new BaseException(ReturnCodeType.UPDATE_ERROR);
        }
    }

}
