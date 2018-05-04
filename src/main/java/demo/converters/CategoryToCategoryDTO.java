package demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import demo.api.v1.model.CategoryDTO;
import demo.domain.Category;
import lombok.Synchronized;
@Component
public class CategoryToCategoryDTO implements Converter<Category, CategoryDTO>{

	@Synchronized
	@Override
	public CategoryDTO convert(Category source) {
		if(source!=null){
			final CategoryDTO catDTO=new CategoryDTO();
			catDTO.setId(source.getId());
			catDTO.setName(source.getName());
			return catDTO;
		}
		return null;
		
		
	}


}
