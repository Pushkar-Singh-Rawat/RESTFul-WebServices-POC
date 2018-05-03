package demo.api.v1.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import demo.api.v1.model.CategoryDTO;
import demo.domain.Category;

public class CategoryMapperTest {

	CategoryMapper mapper= CategoryMapper.INSTANCE;
	private static final String NAME="Demo";
	private static final Long ID=1L;
	
	@Test
	public void testCategoryToCategoryDTO(){
		//given
		Category cat=new Category();
		cat.setId(ID);
		cat.setName(NAME);
		
		//when
		CategoryDTO catDTO=mapper.categoryToCategoryDTO(cat);
		
		//then
		assertEquals(ID,catDTO.getId());
		assertEquals(NAME, catDTO.getName());
	}
}
