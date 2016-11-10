package edu.nju.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="risk_item")
public class RiskItem {

	private int id;
	private String name;
	private String content;//内容
	private String possibility;//可能性
	private String level;//影响程度(高？低)
	private String riskTrigger;//触发器
	private int submitterId;		//提交者
	private int followerId;	//跟踪者
	private String subName;
	private String folName;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getFolName() {
		return folName;
	}
	public void setFolName(String folName) {
		this.folName = folName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPossibility() {
		return possibility;
	}
	public void setPossibility(String possibility) {
		this.possibility = possibility;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getRiskTrigger() {
		return riskTrigger;
	}
	public void setRiskTrigger(String riskTrigger) {
		this.riskTrigger = riskTrigger;
	}
	
	public int getSubmitterId() {
		return submitterId;
	}
	public void setSubmitterId(int submitterId) {
		this.submitterId = submitterId;
	}
	public int getFollowerId() {
		return followerId;
	}
	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}
	@Override
	public String toString() {
		return "RiskItem [id=" + id + ", content=" + content + ", possibility=" + possibility
				+ ", level=" + level+ ", riskTrigger=" + riskTrigger + ", submitter=" + submitterId + ", follower=" + followerId  + "]";
	}
}
