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
 * 政策
 * 
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@Data
@TableName("news")
public class NewsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 政策id
	 */
	@TableId
	private Long newsId;
	/**
	 * 区域
	 */
	private String location;
	/**
	 * 区域类型
	 */
	private String type;
	/**
	 * 政策信息级别
	 */
	private String newsType;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;
	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;
	/**
	 * 政策信息带格式
	 */
	private String newsInfo;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 政策信息不带格式
	 */
	private String infoPlain;
	/**
	 * 浏览次数
	 */
	private Integer number;

}
