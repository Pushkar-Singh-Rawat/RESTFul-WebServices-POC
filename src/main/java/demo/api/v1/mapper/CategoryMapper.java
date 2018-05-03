package demo.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import demo.api.v1.model.CategoryDTO;
import demo.domain.Category;

@Mapper
public interface CategoryMapper {
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	CategoryDTO categoryToCategoryDTO(Category category);

}
