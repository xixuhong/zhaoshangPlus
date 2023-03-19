package com.tmxk.map.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 政策
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@RestController
@RequestMapping("map/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private ChainService chainService;
    @Autowired
    private ChainNewsService chainNewsService;
    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = newsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{newsId}")
    public R info(@PathVariable("newsId") Integer newsId){
		NewsEntity news = newsService.getById(newsId);

        return R.ok().put("news", news);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody NewsEntity news){
        news.setCreateTime(LocalDateTime.now());
		newsService.save(news);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody NewsEntity news){
        news.setUpdateTime(LocalDateTime.now());
		newsService.updateById(news);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] newsIds){
		newsService.removeByIds(Arrays.asList(newsIds));

        return R.ok();
    }

    /**
     * 查询总条数
     * @return
     */
    @PostMapping("/selectNumber")
    public R selectNumber()
    {
        LambdaQueryWrapper<NewsEntity> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByAsc(NewsEntity::getCreateTime);
        List<NewsEntity> list = newsService.list();
        List<NewsEntity> list1 = list;
        int n=0;
        for (NewsEntity newsEntity : list1) {
            n++;
        }
        return R.ok().put("总条数：",n);
    }
    /**
     * 筛选
     * @param location 所在区域
     * @param type 产业类型
     * @param newsType 政策等级
     * @return
     */
    @PostMapping("/getWithMessage")
    public R selectByChoose(String location, String type, String newsType, int curPage){

        LambdaQueryWrapper<ChainEntity> queryWrapper=new LambdaQueryWrapper<>();
        // queryWrapper.eq(ChainEntity::getLocation,location);
        queryWrapper.eq(ChainEntity::getType,type);
        // 查询符合type的产业链
        List<ChainEntity> chainEntities = chainService.list(queryWrapper);
        List<Long> list = new ArrayList<>();
        for (ChainEntity chainEntity : chainEntities) {
            Long chainId = chainEntity.getChainId();
            ChainNewsEntity chainNewsEntity = chainNewsService.getById(chainId);
            Long newsId = chainNewsEntity.getNewsId();
            list.add(newsId);
        }
        if (list.size() == 0)
        {
            return R.ok("暂无政策");
        }
        List<Long> newsEntities = new ArrayList<>();
        // 符合条件的newsId
        for (Long id : list) {
            NewsEntity newsEntity = newsService.getById(id);
            String newsEntityNewsType = newsEntity.getNewsType();
            String location1 = newsEntity.getLocation();
            // 符合条件的id
            if (newsEntityNewsType.equals(newsType)&&location.equals(location1)) {
                newsEntities.add(newsEntity.getNewsId());
            }
        }
        int limit = 3;
        Page<NewsEntity> page = new Page<>(curPage,limit);
        LambdaQueryWrapper<NewsEntity> queryWrapper1=new LambdaQueryWrapper<>();
//        if (newsEntities.size()==0)
//            return R.ok("暂无政策");
//        for (Integer newsEntity : newsEntities) {
//        }
        // newsId存在
        if (newsEntities.size() == 0) {
            return R.ok("暂无政策");
        }else {
            queryWrapper1.in(NewsEntity::getNewsId, newsEntities);
        }
        queryWrapper1.orderByAsc(NewsEntity::getCreateTime);
        newsService.page(page, queryWrapper1);
        return R.ok().put("pageInfo", page);
    }

}
