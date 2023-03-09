package com.tmxk.map.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.Query;

import com.tmxk.map.dao.ProfessionInfoDao;
import com.tmxk.map.entity.ProfessionInfoEntity;
import com.tmxk.map.service.ProfessionInfoService;


@Service("professionInfoService")
public class ProfessionInfoServiceImpl extends ServiceImpl<ProfessionInfoDao, ProfessionInfoEntity> implements ProfessionInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProfessionInfoEntity> page = this.page(
                new Query<ProfessionInfoEntity>().getPage(params),
                new QueryWrapper<ProfessionInfoEntity>()
        );

        return new PageUtils(page);
    }

}