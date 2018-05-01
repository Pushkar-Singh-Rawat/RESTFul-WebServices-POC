package demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
