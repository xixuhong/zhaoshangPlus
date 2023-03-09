package com.tmxk.map.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tmxk.map.entity.ChainNewsEntity;
import com.tmxk.map.service.ChainNewsService;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.R;



/**
 * chain和news的关联表
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@RestController
@RequestMapping("map/chainnews")
public class ChainNewsController {
    @Autowired
    private ChainNewsService chainNewsService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = chainNewsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		ChainNewsEntity chainNews = chainNewsService.getById(id);

        return R.ok().put("chainNews", chainNews);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ChainNewsEntity chainNews){
		chainNewsService.save(chainNews);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody ChainNewsEntity chainNews){
		chainNewsService.updateById(chainNews);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		chainNewsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
