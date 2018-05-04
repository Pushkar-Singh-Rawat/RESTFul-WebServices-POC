package demo.controllers.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.api.v1.model.CategoryDTO;
import demo.api.v1.model.CategoryDTOList;
import demo.services.CategoryService;

@Controller
@RequestMapping("/api/v1/categories/")
public class CategoryController {
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/*
	 * @GetMapping("/api/v1/categories/") public List<CategoryDTO>
	 * getAllCategories() {
	 * 
	 * return categoryService.getAllCategories(); }
	 */
	@GetMapping
	public ResponseEntity<CategoryDTOList> getAllCategories() {
		return new ResponseEntity<CategoryDTOList>(new CategoryDTOList(categoryService.getAllCategories()),
				HttpStatus.OK);
	}

	@GetMapping("{name}")
	public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name) {
		return new ResponseEntity<CategoryDTO>(
				categoryService
				.getCategoryByName(name),
				HttpStatus.OK);

	}

}
