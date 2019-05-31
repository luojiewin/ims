package com.roger.ims.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Menu {
	@JsonIgnore
	private Long rightId;
	
	private String title;
	
	@JsonIgnore
    private Long parentRight;
	
    private String index;
    
    @JsonInclude(Include.NON_EMPTY)
    private String icon;
    
    @JsonInclude(Include.NON_EMPTY)
    private List<Menu> subs = new ArrayList<Menu>();
	public Long getRightId() {
		return rightId;
	}
	public void setRightId(Long rightId) {
		this.rightId = rightId;
	}

	public Long getParentRight() {
		return parentRight;
	}
	public void setParentRight(Long parentRight) {
		this.parentRight = parentRight;
	}

	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	
	public List<Menu> getSubs() {
		return subs;
	}
	public void setSubs(List<Menu> subs) {
		this.subs = subs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	
}
