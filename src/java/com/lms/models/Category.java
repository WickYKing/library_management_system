package com.lms.models;

import java.util.Date;

public class Category {
	private Integer id;
	private String category;
	private Date createDate;
	private Role createdBy;
	private Date updateDate;
	private Role updatedBy;
	private int status;

    public Category(Integer id, String category, Date createDate, Role createdBy, Date updateDate, Role updatedBy, int status) {
        this.id = id;
        this.category = category;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updatedBy = updatedBy;
        this.status = status;
    }

    public Category() {
        
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", category=" + category + ", createDate=" + createDate + ", createdBy=" + createdBy + ", updateDate=" + updateDate + ", updatedBy=" + updatedBy + ", status=" + status + '}';
    }
        
        
        
        
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Role getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Role createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Role getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Role updatedBy) {
		this.updatedBy = updatedBy;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
