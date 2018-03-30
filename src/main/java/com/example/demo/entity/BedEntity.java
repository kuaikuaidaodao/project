package com.example.demo.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午3:21:39
 * @desc 游戏床
 */
@Entity
@Table(name="bed")
public class BedEntity {

	//主键id
	private Long id;
	
	//游戏床id
	private Long bedId;
	
	//所需材料
	private String reqmaterials;
	
	//可选材料
	private String optmaterials;
	
	//所需工具
	private String tool;
	
	//假定条件
	private String condition;
	
	//限制条件
	private String  limit;
	
	//问题
	private String problem;
	
	//所需材料英文
	private String reqmaterialsEn;
	
	//可选材料英文
	private String optmaterialsEn;
	
	//所需工具英文
	private String toolEn;
	
	//假定条件英文
	private String conditionEn;
	
	//限制条件英文
	private String limitEn;
	
	//问题英文
	private String problemEn;

	public BedEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment")
	@Column(name = "ID", nullable = false, precision = 0 )
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Basic
	@Column(name="bed_id")
	public Long getBedId() {
		return bedId;
	}

	public void setBedId(Long bedId) {
		this.bedId = bedId;
	}

	@Basic
	@Column(name="reqmaterials")
	public String getReqmaterials() {
		return reqmaterials;
	}

	public void setReqmaterials(String reqmaterials) {
		this.reqmaterials = reqmaterials;
	}

	@Basic
	@Column(name="optmaterials")
	public String getOptmaterials() {
		return optmaterials;
	}

	public void setOptmaterials(String optmaterials) {
		this.optmaterials = optmaterials;
	}

	@Basic
	@Column(name="tool")
	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	@Basic
	@Column(name="condition")
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Basic
	@Column(name="limit")
	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	@Basic
	@Column(name="problem")
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Basic
	@Column(name="reqmaterials_en")
	public String getReqmaterialsEn() {
		return reqmaterialsEn;
	}

	public void setReqmaterialsEn(String reqmaterialsEn) {
		this.reqmaterialsEn = reqmaterialsEn;
	}

	@Basic
	@Column(name="optmaterials_en")
	public String getOptmaterialsEn() {
		return optmaterialsEn;
	}

	public void setOptmaterialsEn(String optmaterialsEn) {
		this.optmaterialsEn = optmaterialsEn;
	}

	@Basic
	@Column(name="tool_en")
	public String getToolEn() {
		return toolEn;
	}

	public void setToolEn(String toolEn) {
		this.toolEn = toolEn;
	}

	@Basic
	@Column(name="condition_en")
	public String getConditionEn() {
		return conditionEn;
	}

	public void setConditionEn(String conditionEn) {
		this.conditionEn = conditionEn;
	}

	@Basic
	@Column(name="limit_en")
	public String getLimitEn() {
		return limitEn;
	}

	public void setLimitEn(String limitEn) {
		this.limitEn = limitEn;
	}

	@Basic
	@Column(name="problem_en")
	public String getProblemEn() {
		return problemEn;
	}

	public void setProblemEn(String problemEn) {
		this.problemEn = problemEn;
	}
}
