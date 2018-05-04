package demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Category findByName(String name);
}
