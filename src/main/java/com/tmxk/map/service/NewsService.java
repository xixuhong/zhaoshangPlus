package com.tmxk.map.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.map.entity.NewsEntity;

import java.util.Map;

/**
 * 政策
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
public interface NewsService extends IService<NewsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

