package com.tmxk.map.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tmxk.map.entity.ChainEntity;
import com.tmxk.map.service.ChainService;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.R;



/**
 * 
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@RestController
@RequestMapping("map/chain")
public class ChainController {
    @Autowired
    private ChainService chainService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = chainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{chainId}")
    public R info(@PathVariable("chainId") Integer chainId){
		ChainEntity chain = chainService.getById(chainId);

        return R.ok().put("chain", chain);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ChainEntity chain){
		chainService.save(chain);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody ChainEntity chain){
		chainService.updateById(chain);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] chainIds){
		chainService.removeByIds(Arrays.asList(chainIds));

        return R.ok();
    }

}
