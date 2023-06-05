package com.lms.models;

import java.util.Date;

public class Permission {
	private Integer id;
	private String permission;
	private Date createDate;
	private Integer createdBy;
	private Date updateDate;
	private Integer updatedBy;
	private int status;

    public Permission(Integer id, String permission, Date createDate, Integer createdBy, Date updateDate, Integer updatedBy, int status) {
        this.id = id;
        this.permission = permission;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updatedBy = updatedBy;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Permission{" + "id=" + id + ", permission=" + permission + ", createDate=" + createDate + ", createdBy=" + createdBy + ", updateDate=" + updateDate + ", updatedBy=" + updatedBy + ", status=" + status + '}';
    }
        
        
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
	

}
