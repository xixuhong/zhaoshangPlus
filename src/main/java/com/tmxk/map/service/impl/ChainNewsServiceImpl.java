package com.tmxk.map.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.Query;

import com.tmxk.map.dao.ChainNewsDao;
import com.tmxk.map.entity.ChainNewsEntity;
import com.tmxk.map.service.ChainNewsService;


@Service("chainNewsService")
public class ChainNewsServiceImpl extends ServiceImpl<ChainNewsDao, ChainNewsEntity> implements ChainNewsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ChainNewsEntity> page = this.page(
                new Query<ChainNewsEntity>().getPage(params),
                new QueryWrapper<ChainNewsEntity>()
        );

        return new PageUtils(page);
    }

}