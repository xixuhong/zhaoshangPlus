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
 * 人才基本信息
 * 
 * @author Xi
 * @email 2722029950@qq.com
 * @date 2023-03-09 15:31:55
 */
@Data
@TableName("profession_info")
public class ProfessionInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 人才id
	 */
	@TableId
	private Long professionalId;
	/**
	 * 人才照片
	 */
	private String picture;
	/**
	 * 发布时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;
	/**
	 * 职位类型
	 */
	private String occupationType;
	/**
	 * 地址
	 */
	private String location;
	/**
	 * 企业名称
	 */
	private String businessName;
	/**
	 * 企业电话
	 */
	private String businessTel;
	/**
	 * 企业地址
	 */
	private String businessLocation;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 年龄
	 */
	private String age;
	/**
	 * 服务费
	 */
	private String servicePrice;
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
