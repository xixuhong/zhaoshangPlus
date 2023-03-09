package com.tmxk.map.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.Query;

import com.tmxk.map.dao.ProWorkDao;
import com.tmxk.map.entity.ProWorkEntity;
import com.tmxk.map.service.ProWorkService;


@Service("proWorkService")
public class ProWorkServiceImpl extends ServiceImpl<ProWorkDao, ProWorkEntity> implements ProWorkService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProWorkEntity> page = this.page(
                new Query<ProWorkEntity>().getPage(params),
                new QueryWrapper<ProWorkEntity>()
        );

        return new PageUtils(page);
    }

}