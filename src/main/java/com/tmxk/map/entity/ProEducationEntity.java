package com.tmxk.map.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 教育经历
 * 
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@Data
@TableName("pro_education")
public class ProEducationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 人才id
	 */
	@TableId
	private Integer professionalId;
	/**
	 * 毕业院校
	 */
	private String college;
	/**
	 * 专业教育
	 */
	private String course;
	/**
	 * 入学—毕业时间
	 */
	private String time;
	/**
	 * 最高学历
	 */
	private String educationMax;

}
