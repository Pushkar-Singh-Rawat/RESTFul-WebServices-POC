package demo.controller.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.mockito.*;
import demo.api.v1.model.CategoryDTO;
import demo.controllers.RestResponseEntityExceptionHandler;
import demo.controllers.v1.CategoryController;
import demo.services.CategoryService;
import demo.services.ResourceNotFoundException;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatcher.*;

public class CategoryControllerTests {
	public static final String NAME1="Tim Took";
	public static final String NAME2="John Constantine";

	@Mock
	CategoryService categoryservice;
	@InjectMocks
	CategoryController categoryController;
	MockMvc mockMVC;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockMVC=MockMvcBuilders.standaloneSetup(categoryController)
				.setControllerAdvice(new RestResponseEntityExceptionHandler()).build();    
	}

	@Test
	public void testGetAllCategories() throws Exception{
		CategoryDTO one=new CategoryDTO();
		one.setName(NAME1);
		one.setId(1L);
		CategoryDTO two=new CategoryDTO();
		two.setName(NAME2);
		two.setId(1L);	
		/*List<CategoryDTO> catList=new ArrayList<>();
		catList.add(one);
		catList.add(two);*/
		List<CategoryDTO> catList=Arrays.asList(one,two);
		Mockito.when(categoryservice.getAllCategories()).thenReturn(catList);
		mockMVC.perform(get("/api/v1/categories/")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.categories",hasSize(2)));	
	}

	@Test
	public void testGetCategoryByName() throws Exception{
		CategoryDTO one=new CategoryDTO();
		one.setName(NAME1);
		one.setId(1L);
		Mockito.when(categoryservice.getCategoryByName(Mockito.anyString())).thenReturn(one);
		mockMVC.perform(get("/api/v1/categories/"+NAME1)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name", equalTo(NAME1)));
	}
	@Test
	public void testGetCategoryByNameNotFound() throws Exception{

		Mockito.when(categoryservice.getCategoryByName(Mockito.anyString())).thenThrow(ResourceNotFoundException.class);
		mockMVC.perform(get("/api/v1/categories/"+NAME1)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());

	}
}