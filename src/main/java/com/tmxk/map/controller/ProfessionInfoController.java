package com.tmxk.map.controller;

import java.util.Arrays;
import java.util.Map;

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
@RestController
@RequestMapping("map/professioninfo")
public class ProfessionInfoController {
    @Autowired
    private ProfessionInfoService professionInfoService;

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
		ProfessionInfoEntity professionInfo = professionInfoService.getById(professionalId);

        return R.ok().put("professionInfo", professionInfo);
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
