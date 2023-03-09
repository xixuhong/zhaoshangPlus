package com.tmxk.map.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.Query;

import com.tmxk.map.dao.ParkInfoDao;
import com.tmxk.map.entity.ParkInfoEntity;
import com.tmxk.map.service.ParkInfoService;


@Service("parkInfoService")
public class ParkInfoServiceImpl extends ServiceImpl<ParkInfoDao, ParkInfoEntity> implements ParkInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ParkInfoEntity> page = this.page(
                new Query<ParkInfoEntity>().getPage(params),
                new QueryWrapper<ParkInfoEntity>()
        );

        return new PageUtils(page);
    }

}