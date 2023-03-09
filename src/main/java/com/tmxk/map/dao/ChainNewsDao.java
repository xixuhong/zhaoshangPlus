package com.tmxk.map.dao;

import com.tmxk.map.entity.ChainNewsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * chain和news的关联表
 * 
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@Mapper
public interface ChainNewsDao extends BaseMapper<ChainNewsEntity> {
	
}
