package com.tmxk.map.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.map.entity.ParkInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:55
 */
public interface ParkInfoService extends IService<ParkInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

