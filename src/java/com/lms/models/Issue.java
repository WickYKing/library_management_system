package com.lms.models;

import java.util.Date;

public class Issue {
	private Integer id;
	private Book book;
	private Student student;
	private Date issueDate;
	private User issuedBy;
	private Role createdBy;
	private Date createDate;
	private Role updatedBy;
	private Date updateDate;
	private int status;

    public Issue(Integer id, Book book, Student student, Date issueDate, User issuedBy, Role createdBy, Date createDate, Role updatedBy, Date updateDate, int status) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.issueDate = issueDate;
        this.issuedBy = issuedBy;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.updatedBy = updatedBy;
        this.updateDate = updateDate;
        this.status = status;
    }

    public Issue() {
       
    }

   

    @Override
    public String toString() {
        return "Issue{" + "id=" + id + ", book=" + book + ", student=" + student + ", issueDate=" + issueDate + ", issuedBy=" + issuedBy + ", createdBy=" + createdBy + ", createDate=" + createDate + ", updatedBy=" + updatedBy + ", updateDate=" + updateDate + ", status=" + status + '}';
    }
        
        
        
        
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public User getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(User issuedBy) {
		this.issuedBy = issuedBy;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Role getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Role createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Role getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Role updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	

}
