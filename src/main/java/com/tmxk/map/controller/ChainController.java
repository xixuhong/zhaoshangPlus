package com.tmxk.map.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.common.utils.R;
import com.tmxk.map.entity.ChainEntity;
import com.tmxk.map.entity.ChainNewsEntity;
import com.tmxk.map.entity.NewsEntity;
import com.tmxk.map.service.ChainNewsService;
import com.tmxk.map.service.ChainService;
import com.tmxk.map.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

    @Autowired
    private NewsService newsService;

    @Autowired
    private ChainNewsService chainNewsService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = chainService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 获取ChainList
     * @return
     */
    @GetMapping(value = "/getChainList")
    public R getChainList() {

        List<ChainEntity> list = chainService.list();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", list);
        return R.ok(map);
    }

    /**
     * 根据ID查询
     * @return
     */
    @GetMapping(value = "/findChain/{id}")
    public R getById(@PathVariable Long id) {
        ChainEntity chain = chainService.getById(id);
        HashMap<String, Object> map = new HashMap<>();
        if (chain == null) {
            return R.error("id错误");
        }
        map.put("data", chain);
        return R.ok(map);
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

    /**
     * 根据chain_type查询关联政策
     */
    @GetMapping("chain_type")
    public R chainType(@RequestParam String chainType) {
        // 1. 查询chain_id
        LambdaQueryWrapper<ChainEntity> query = new LambdaQueryWrapper<>();
        query.eq(ChainEntity::getType, chainType);
        ChainEntity chain = chainService.getOne(query);
        // 2. 查询news_id
        LambdaQueryWrapper<ChainNewsEntity> query2 = new LambdaQueryWrapper<>();
        query2.eq(ChainNewsEntity::getChainId, chain.getChainId());
        List<ChainNewsEntity> list = chainNewsService.list(query2);
        List<Long> idList = list.stream().map(ChainNewsEntity::getNewsId).collect(Collectors.toList());
        // 根据news_id查询news
        List<NewsEntity> newsEntities = newsService.listByIds(idList);
        return R.ok().put("data", newsEntities);
    }
}
