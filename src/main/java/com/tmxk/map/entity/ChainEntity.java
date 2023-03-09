package com.tmxk.map.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@Data
@TableName("chain")
public class ChainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 区域
	 */
	private String location;
	/**
	 * 产业类型
	 */
	private String type;
	/**
	 * 产业链id
	 */
	@TableId
	private Integer chainId;
	/**
	 * 产业介绍
	 */
	private String introduction;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 招商方向
	 */
	private String direction;
	/**
	 * 招商政策
	 */
	private String policy;
	/**
	 * 是否是重点企业
	 */
	private Integer grade;
	/**
	 * 首页配置信息
	 */
	private String frontConfig;

}
