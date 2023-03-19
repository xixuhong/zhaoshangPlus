package com.tmxk.map.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:55
 */
@Data
@TableName("park_info")
public class ParkInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 所属地区
	 */
	private String location;
	/**
	 * 园区id
	 */
	@TableId
	private Long parkId;
	/**
	 * 园区级别
	 */
	private String grade;
	/**
	 * 产业链
	 */
	private String chain;
	/**
	 * 园区名字
	 */
	private String parkName;
	/**
	 * 园区图片
	 */
	private String img;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;
	/**
	 * 修改时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;
	/**
	 * 首页配置信息
	 */
	private String frontConfig;
	/**
	 * 园区描述信息
	 */
	private String description;
	/**
	 * 园区详细地址
	 */
	private String address;
	/**
	 * 园区联系电话
	 */
	private String phone;

}
