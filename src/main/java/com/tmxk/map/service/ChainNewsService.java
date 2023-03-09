package com.tmxk.map.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.map.entity.ChainNewsEntity;

import java.util.Map;

/**
 * chain和news的关联表
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
public interface ChainNewsService extends IService<ChainNewsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

