package com.tmxk.map.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.Query;
import com.tmxk.map.dao.ParkInfoDao;
import com.tmxk.map.entity.ParkInfoEntity;
import com.tmxk.map.service.ParkInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("parkInfoService")
public class ParkInfoServiceImpl extends ServiceImpl<ParkInfoDao, ParkInfoEntity> implements ParkInfoService {

    @Resource
    private ParkInfoDao parkInfoDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ParkInfoEntity> page = this.page(
                new Query<ParkInfoEntity>().getPage(params),
                new QueryWrapper<ParkInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Object getParkIdByparkName(String parkName) {
        // 获取参数
        Map<String, Object> map = new HashMap<>();
        String name="";
        try {
            name = URLDecoder.decode(parkName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        map.put("park_name", name);
        //返回结果为单个值
        List<ParkInfoEntity> parks = parkInfoDao.selectByMap(map);
        if (parks.size()> 0) {
            ParkInfoEntity park = parks.get(0);
            return park.getParkId();
        } else {
            return null;
        }
    }

    @Override
    public ParkInfoEntity getByGrade(String grade) {
        // 获取参数
        Map<String, Object> map = new HashMap<>();
        String name="";
        try {
            grade = URLDecoder.decode(grade, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        map.put("grade", grade);
        //返回结果为单个值
        List<ParkInfoEntity> parks = parkInfoDao.selectByMap(map);
        if (parks.size()> 0) {
            ParkInfoEntity park = parks.get(0);
            LambdaQueryWrapper<ParkInfoEntity> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ParkInfoEntity::getGrade, park.getGrade());
            ParkInfoEntity one = this.getOne(queryWrapper);
            return one;
        } else {
            return null;
        }
    }

}