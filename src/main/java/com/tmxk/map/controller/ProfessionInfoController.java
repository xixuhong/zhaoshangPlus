package com.tmxk.map.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tmxk.map.entity.ProEducationEntity;
import com.tmxk.map.entity.ProWorkEntity;
import com.tmxk.map.service.ProEducationService;
import com.tmxk.map.service.ProWorkService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tmxk.map.entity.ProfessionInfoEntity;
import com.tmxk.map.service.ProfessionInfoService;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.R;



/**
 * 人才基本信息
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:55
 */
@Slf4j
@RestController
@RequestMapping("map/professioninfo")
public class ProfessionInfoController {
    @Autowired
    private ProfessionInfoService professionInfoService;
    @Autowired
    private ProEducationService proEducationService;
    @Autowired
    private ProWorkService proWorkService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = professionInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{professionalId}")
    public R info(@PathVariable("professionalId") Integer professionalId){
        List<Object> list = new ArrayList<>();
		ProfessionInfoEntity professionInfo = professionInfoService.getById(professionalId);

        LambdaQueryWrapper<ProEducationEntity> query1 = new LambdaQueryWrapper<>();
        query1.eq(ProEducationEntity::getProfessionalId,professionalId);
        List<ProEducationEntity> proEducation = proEducationService.list(query1);

        LambdaQueryWrapper<ProWorkEntity> query2 = new LambdaQueryWrapper<>();
        query2.eq(ProWorkEntity::getProfessionalId,professionalId)
        .orderByAsc(ProWorkEntity::getWorkTime);
        List<ProWorkEntity> proWork = proWorkService.list(query2);


        list.add(professionInfo);
        list.addAll(proEducation);
        list.addAll(proWork);

        return R.ok().put("professionInfoAll", list);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProfessionInfoEntity professionInfo){
		professionInfoService.save(professionInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody ProfessionInfoEntity professionInfo){
		professionInfoService.updateById(professionInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] professionalIds){
		professionInfoService.removeByIds(Arrays.asList(professionalIds));

        return R.ok();
    }

}
