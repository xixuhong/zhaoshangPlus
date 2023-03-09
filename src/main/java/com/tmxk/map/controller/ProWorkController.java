package com.tmxk.map.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tmxk.map.entity.ProWorkEntity;
import com.tmxk.map.service.ProWorkService;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.R;



/**
 * 工作经历
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@RestController
@RequestMapping("map/prowork")
public class ProWorkController {
    @Autowired
    private ProWorkService proWorkService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = proWorkService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{professionalId}")
    public R info(@PathVariable("professionalId") Integer professionalId){
		ProWorkEntity proWork = proWorkService.getById(professionalId);

        return R.ok().put("proWork", proWork);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ProWorkEntity proWork){
		proWorkService.save(proWork);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody ProWorkEntity proWork){
		proWorkService.updateById(proWork);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] professionalIds){
		proWorkService.removeByIds(Arrays.asList(professionalIds));

        return R.ok();
    }

}
