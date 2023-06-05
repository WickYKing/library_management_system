package com.lms.dao;

import java.util.List;
import com.lms.models.Category;

public interface CategoryDao {
	public Integer addCategory(Category category);
	public Integer updateCategory(Category category);
	public Integer deleteCategory(Integer id);
	public Integer getIdByName(String name);
	public Category getCategoryById(Integer id);
	public List<Category> getAllCategory();
}
