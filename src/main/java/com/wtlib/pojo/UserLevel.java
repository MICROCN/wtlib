<<<<<<< HEAD
package com.wtlib.pojo;

/**
 * 用户等级实体
 * 
 * @author zongzi
 * @date 2017年1月21日 下午6:02:57
 */
public class UserLevel extends BaseEntity {
	private static final long serialVersionUID = 3732239083609170031L;

	private Integer id;

	private String levelName;

	private String levelMinCreditValue;

	private Double levelWeight;

	private String levelDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName == null ? null : levelName.trim();
	}

	public String getLevelMinCreditValue() {
		return levelMinCreditValue;
	}

	public void setLevelMinCreditValue(String levelMinCreditValue) {
		this.levelMinCreditValue = levelMinCreditValue == null ? null
				: levelMinCreditValue.trim();
	}

	public Double getLevelWeight() {
		return levelWeight;
	}

	public void setLevelWeight(Double levelWeight) {
		this.levelWeight = levelWeight;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc == null ? null : levelDesc.trim();
	}

=======
package com.wtlib.pojo;

/**
 * 用户等级实体
 * 
 * @author zongzi
 * @date 2017年1月21日 下午6:02:57
 */
public class UserLevel extends BaseEntity {
	private static final long serialVersionUID = 3732239083609170031L;

	private Integer id;

	private String levelName;

	private String levelMinCreditValue;

	private Double levelWeight;

	private String levelDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName == null ? null : levelName.trim();
	}

	public String getLevelMinCreditValue() {
		return levelMinCreditValue;
	}

	public void setLevelMinCreditValue(String levelMinCreditValue) {
		this.levelMinCreditValue = levelMinCreditValue == null ? null
				: levelMinCreditValue.trim();
	}

	public Double getLevelWeight() {
		return levelWeight;
	}

	public void setLevelWeight(Double levelWeight) {
		this.levelWeight = levelWeight;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc == null ? null : levelDesc.trim();
	}

>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
}