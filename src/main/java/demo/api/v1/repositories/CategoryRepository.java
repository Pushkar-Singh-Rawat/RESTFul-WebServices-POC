package demo.api.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.api.v1.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
