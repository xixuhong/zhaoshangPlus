package com.tmxk.map.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.Query;

import com.tmxk.map.dao.ProfessionalDao;
import com.tmxk.map.entity.ProfessionalEntity;
import com.tmxk.map.service.ProfessionalService;


@Service("professionalService")
public class ProfessionalServiceImpl extends ServiceImpl<ProfessionalDao, ProfessionalEntity> implements ProfessionalService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProfessionalEntity> page = this.page(
                new Query<ProfessionalEntity>().getPage(params),
                new QueryWrapper<ProfessionalEntity>()
        );

        return new PageUtils(page);
    }

}