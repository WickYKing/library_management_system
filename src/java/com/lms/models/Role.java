package com.lms.models;

import java.util.Date;

import javax.swing.text.InternationalFormatter;

public class Role {
	private Integer id;
	private String role;
	private Date createDate;
	private Role createdBy;
	private Date updateDate;
	private Role updatedBy;
	private int status;

    public Role() {
    }

    public Role(Integer id, String role, Date createDate, Role createdBy, Date updateDate, Role updatedBy, int status) {
        this.id = id;
        this.role = role;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updatedBy = updatedBy;
        this.status = status;
    }


    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", role=" + role + ", createDate=" + createDate + ", createdBy=" + createdBy + ", updateDate=" + updateDate + ", updatedBy=" + updatedBy + ", status=" + status + '}';
    }
        
        
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
