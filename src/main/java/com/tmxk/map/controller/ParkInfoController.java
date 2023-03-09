package com.tmxk.map.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tmxk.map.entity.ParkInfoEntity;
import com.tmxk.map.service.ParkInfoService;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.R;



/**
 * 
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:55
 */
@RestController
@RequestMapping("map/parkinfo")
public class ParkInfoController {
    @Autowired
    private ParkInfoService parkInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = parkInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{parkId}")
    public R info(@PathVariable("parkId") Integer parkId){
		ParkInfoEntity parkInfo = parkInfoService.getById(parkId);

        return R.ok().put("parkInfo", parkInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ParkInfoEntity parkInfo){
		parkInfoService.save(parkInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody ParkInfoEntity parkInfo){
		parkInfoService.updateById(parkInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] parkIds){
		parkInfoService.removeByIds(Arrays.asList(parkIds));

        return R.ok();
    }

}
