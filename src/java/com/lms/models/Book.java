package com.lms.models;

import java.util.Date;

public class Book {
	private Integer id;
	private String bookCode;
	private String title;
	private String author;
	private Integer noOfCopies;
	private Category category;
	private Date createDate;
	private Role createdBy;
	private Date updateDate;
	private Role updatedBy;
	private int status;

    public Book(Integer id, String bookCode, String title, String author, Integer noOfCopies, Category category, Date createDate, Role createdBy, Date updateDate, Role updatedBy, int status) {
        this.id = id;
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.noOfCopies = noOfCopies;
        this.category = category;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updatedBy = updatedBy;
        this.status = status;
    }

    public Book() {
       
    }

 
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", bookCode=" + bookCode + ", title=" + title + ", author=" + author + ", noOfCopies=" + noOfCopies + ", category=" + category + ", createDate=" + createDate + ", createdBy=" + createdBy + ", updateDate=" + updateDate + ", updatedBy=" + updatedBy + ", status=" + status + '}';
    }
	
	
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
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
