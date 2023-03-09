package com.tmxk.map.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 专业人才
 * 
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:56
 */
@Data
@TableName("professional")
public class ProfessionalEntity implements Serializable {
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
	 * 职位类型
	 */
	private String occupationType;
	/**
	 * 人才id
	 */
	@TableId
	private Integer professionalId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 工作年限
	 */
	private String workYears;
	/**
	 * 最高学历
	 */
	private String educationMax;
	/**
	 * 管理规模
	 */
	private String manageScale;
	/**
	 * 曾就职名企
	 */
	private String company;
	/**
	 * 业绩能力
	 */
	private String achievement;
	/**
	 * 代表产品
	 */
	private String productRepresent;
	/**
	 * 擅长技能
	 */
	private String skill;

}
