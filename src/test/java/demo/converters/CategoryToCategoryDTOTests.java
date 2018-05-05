package demo.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import demo.api.v1.model.CategoryDTO;
import demo.domain.Category;

public class CategoryToCategoryDTOTests {
	CategoryToCategoryDTO categoryToCategoryDTO;
	@Before
	public void setup(){
	 categoryToCategoryDTO=new CategoryToCategoryDTO();
	}
	
	@Test
     public void testNullCheck(){
		CategoryDTO catDTO=categoryToCategoryDTO.convert(null);
		assertNull(catDTO);
	}
	@Test
	public void testConverter(){
		Category cat=new Category();
		cat.setId(1L);
		cat.setName("James");
		CategoryDTO catDTO=categoryToCategoryDTO.convert(cat);
		assertEquals(Long.valueOf(1L),catDTO.getId());
		assertEquals("James", catDTO.getName());
	}
	
}
