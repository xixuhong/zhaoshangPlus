package com.tmxk.map.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.Query;

import com.tmxk.map.dao.ChainDao;
import com.tmxk.map.entity.ChainEntity;
import com.tmxk.map.service.ChainService;


@Service("chainService")
public class ChainServiceImpl extends ServiceImpl<ChainDao, ChainEntity> implements ChainService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ChainEntity> page = this.page(
                new Query<ChainEntity>().getPage(params),
                new QueryWrapper<ChainEntity>()
        );

        return new PageUtils(page);
    }

}