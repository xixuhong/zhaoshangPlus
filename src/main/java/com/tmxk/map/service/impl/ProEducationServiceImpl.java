package com.tmxk.map.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.Query;

import com.tmxk.map.dao.ProEducationDao;
import com.tmxk.map.entity.ProEducationEntity;
import com.tmxk.map.service.ProEducationService;


@Service("proEducationService")
public class ProEducationServiceImpl extends ServiceImpl<ProEducationDao, ProEducationEntity> implements ProEducationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProEducationEntity> page = this.page(
                new Query<ProEducationEntity>().getPage(params),
                new QueryWrapper<ProEducationEntity>()
        );

        return new PageUtils(page);
    }

}