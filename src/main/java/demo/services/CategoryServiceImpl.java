package demo.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import demo.api.v1.model.CategoryDTO;
import demo.converters.CategoryToCategoryDTO;
import demo.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	CategoryRepository categoryRepository;
	CategoryToCategoryDTO categoryToCategoryDTO;

	//injected required dependencies
	public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryToCategoryDTO categoryToCategoryDTO) {
		this.categoryRepository = categoryRepository;
		this.categoryToCategoryDTO = categoryToCategoryDTO;
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		
		return categoryRepository
				.findAll()
				.stream()
				.map(categoryToCategoryDTO::convert)
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDTO getCategoryByName(String name) {
		
		return categoryToCategoryDTO.convert(categoryRepository.findByName(name));
	}

}
