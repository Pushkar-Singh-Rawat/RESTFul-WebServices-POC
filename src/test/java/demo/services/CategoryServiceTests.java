package demo.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import demo.domain.Category;
import demo.api.v1.model.CategoryDTO;
import demo.converters.CategoryToCategoryDTO;
import demo.repositories.CategoryRepository;

public class CategoryServiceTests {
	private final CategoryToCategoryDTO categoryToCategoryDTO;
	@Mock
	CategoryRepository categoryRepository;
	CategoryService categoryService;

	public CategoryServiceTests() {
		this.categoryToCategoryDTO = new CategoryToCategoryDTO();
	}

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		categoryService = new CategoryServiceImpl(categoryRepository, categoryToCategoryDTO);
	}

	@Test
	public void testGetAllCategories() throws Exception {

		Category cat1 = new Category();
		Category cat2 = new Category();
		cat1.setId(1L);
		cat1.setName("James");
		cat2.setId(2L);
		cat2.setName("Gosling");
		List<Category> catList = Arrays.asList(cat1, cat2);
		Mockito.when(categoryRepository.findAll()).thenReturn(catList);
		List<CategoryDTO> dtoList = categoryService.getAllCategories();
		assertEquals(2, dtoList.size());
	}

	@Test
	public void testGetCategoryByName() throws Exception {
		Category cat1 = new Category();
		cat1.setId(1L);
		cat1.setName("James");
        Mockito.when(categoryRepository.findByName(Mockito.anyString())).thenReturn(cat1);
        CategoryDTO catDto=categoryService.getCategoryByName("James");
        assertEquals("James",catDto.getName());
        assertEquals(Long.valueOf(1L), catDto.getId());
	}
}
