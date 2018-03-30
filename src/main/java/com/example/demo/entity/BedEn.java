package com.example.demo.entity;

/**
 * 
 * @author xwj
 * @date 2018年3月30日 下午3:35:11
 * @desc 游戏床英文版
 */
public class BedEn {

	// 主键id
	private Long id;

	// 游戏床id
	private Long bedId;

	// 所需材料英文
	private String reqmaterials;

	// 可选材料英文
	private String optmaterials;

	// 所需工具英文
	private String tool;

	// 假定条件英文
	private String condition;

	// 限制条件英文
	private String limit;

	// 问题英文
	private String problem;

	public BedEn() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBedId() {
		return bedId;
	}

	public void setBedId(Long bedId) {
		this.bedId = bedId;
	}

	public String getReqmaterials() {
		return reqmaterials;
	}

	public void setReqmaterials(String reqmaterials) {
		this.reqmaterials = reqmaterials;
	}

	public String getOptmaterials() {
		return optmaterials;
	}

	public void setOptmaterials(String optmaterials) {
		this.optmaterials = optmaterials;
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

}
