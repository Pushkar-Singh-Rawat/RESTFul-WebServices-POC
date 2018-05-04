package demo.services;

import java.util.List;

import demo.api.v1.model.CategoryDTO;

public interface CategoryService {

	public List<CategoryDTO> getAllCategories();
	public CategoryDTO getCategoryByName(String name);
	
}
