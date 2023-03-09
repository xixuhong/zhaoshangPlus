package com.tmxk.map.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tmxk.map.entity.ProEducationEntity;
import com.tmxk.map.service.ProEducationService;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.R;



/**
 * 教育经历
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@RestController
@RequestMapping("map/proeducation")
public class ProEducationController {
    @Autowired
    private ProEducationService proEducationService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = proEducationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{professionalId}")
    public R info(@PathVariable("professionalId") Integer professionalId){
		ProEducationEntity proEducation = proEducationService.getById(professionalId);

        return R.ok().put("proEducation", proEducation);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProEducationEntity proEducation){
		proEducationService.save(proEducation);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody ProEducationEntity proEducation){
		proEducationService.updateById(proEducation);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] professionalIds){
		proEducationService.removeByIds(Arrays.asList(professionalIds));

        return R.ok();
    }

}
