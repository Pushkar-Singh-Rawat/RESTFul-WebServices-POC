package demo.controllers.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.api.v1.model.CategoryDTO;
import demo.api.v1.model.CategoryDTOList;
import demo.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController // combination of controller and responsebody annotations.
@RequestMapping("/api/v1/categories")
public class CategoryController {
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/*
	 * @GetMapping public ResponseEntity<CategoryDTOList> getAllCategories() {
	 * return new ResponseEntity<CategoryDTOList>(new
	 * CategoryDTOList(categoryService.getAllCategories()), HttpStatus.OK); }
	 */
	@ApiOperation(notes="these are some of the API notes",value="This will get a list of categories")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public CategoryDTOList getAllCategories() {
		return new CategoryDTOList(categoryService.getAllCategories());
	}

	/*
	 * @GetMapping("/{name}") public ResponseEntity<CategoryDTO>
	 * getCategoryByName(@PathVariable String name) { return new
	 * ResponseEntity<CategoryDTO>( categoryService .getCategoryByName(name),
	 * HttpStatus.OK);}
	 */
	@ApiOperation(notes="these are some of the API notes",value="This will get any category by name.")
	@GetMapping("/{name}")
	@ResponseStatus(HttpStatus.OK)
	public CategoryDTO getCategoryByName(@PathVariable String name) {
		return categoryService.getCategoryByName(name);
	}
}
