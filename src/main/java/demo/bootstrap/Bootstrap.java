package demo.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import demo.entity.Category;
import demo.repositories.CategoryRepository;

@Component
public class Bootstrap implements CommandLineRunner{

	CategoryRepository categoryRepository;
	
	public Bootstrap(CategoryRepository categoryRepository){
		this.categoryRepository=categoryRepository;
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Category fruits=new Category();
		fruits.setName("Fruits");
		Category dried=new Category();
		fruits.setName("Dried");
		Category fresh=new Category();
		fruits.setName("Fresh");
		Category exotic=new Category();
		fruits.setName("Exotic");
		Category nuts=new Category();
		fruits.setName("Nuts");
		/*List<Category> categories=new ArrayList<>();
		categories.add(fruits);
		categories.add(nuts);
		categories.add(dried);
		categories.add(fresh);
		categories.add(exotic);
		categoryRepository.save(categories);*/
		
		categoryRepository.save(fruits);
		categoryRepository.save(dried);
		categoryRepository.save(fresh);
		categoryRepository.save(exotic);
		categoryRepository.save(nuts);
		
		System.out.println("data loaded +++++++"+categoryRepository.count());
		
		
	}
	
}
