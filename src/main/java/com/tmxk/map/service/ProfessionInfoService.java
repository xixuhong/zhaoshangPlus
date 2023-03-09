package com.tmxk.map.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tmxk.common.utils.PageUtils;
import com.tmxk.map.entity.ProfessionInfoEntity;

import java.util.Map;

/**
 * 人才基本信息
 *
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:55
 */
public interface ProfessionInfoService extends IService<ProfessionInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

