package com.tmxk.map.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 工作经历
 * 
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@Data
@TableName("pro_work")
public class ProWorkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 人才id
	 */
	@TableId
	private Long professionalId;
	/**
	 * 公司名
	 */
	private String business;
	/**
	 * 工作时间
	 */
	private String workTime;
	/**
	 * 职位
	 */
	private String post;
	/**
	 * 工作内容
	 */
	private String content;

}
