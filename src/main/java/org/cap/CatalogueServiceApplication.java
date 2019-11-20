package org.cap;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.cap.dao.CategoryRepository;
import org.cap.dao.ProductRepository;
import org.cap.entities.Category;
import org.cap.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CatalogueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueServiceApplication.class, args);
	}

	
	@Bean
	CommandLineRunner start(CategoryRepository categoryRepository,ProductRepository productRepository) {
		return args-> {
			categoryRepository.deleteAll();
		Stream.of("C1 Ordinateurs","C2 Imprimantes").forEach(c->{
			categoryRepository.save(new Category(c.split(" ")[0],c.split(" ")[1],new ArrayList<>()));
		});
			categoryRepository.findAll().forEach(System.out::println);
			
			
		productRepository.deleteAll();
			
			Category C1=categoryRepository.findById("C1").get();
			Stream.of("P1","P2","P3").forEach(name->{
			Product p=productRepository.save(new Product(null, name, Math.random()*1000, C1));
			C1.getProducts().add(p);
			categoryRepository.save(C1);
			});
			
			
			Category C2=categoryRepository.findById("C2").get();
			Stream.of("P4","P5","P6").forEach(name2->{
			Product p1=productRepository.save(new Product(null, name2, Math.random()*1000, C2));
			C2.getProducts().add(p1);
			categoryRepository.save(C2);
			});
			
			productRepository.findAll().forEach(p->{
                       System.out.println(p.toString());
     		});
	
		
};
}}