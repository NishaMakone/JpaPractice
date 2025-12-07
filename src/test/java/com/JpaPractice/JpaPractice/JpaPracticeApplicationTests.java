package com.JpaPractice.JpaPractice;

import com.JpaPractice.JpaPractice.entities.ProductEntity;
import com.JpaPractice.JpaPractice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaPracticeApplicationTests {

    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testRepository(){
        ProductEntity productEntity = ProductEntity.builder()
                .sku("nestle234")
                .title("Nestle chocolate")
                .price(BigDecimal.valueOf(123.45))
                .quantity(12)
                .build();
        ProductEntity savedProductEntity = productRepository.save(productEntity);
        System.out.println(savedProductEntity);

    }

   /* @Test
    void getRepository(){
        List<ProductEntity> entities = productRepository.findByTitle("Pepsi");
        System.out.println(entities);
    }*/
    @Test
   void getRepository(){
     //  List<ProductEntity> entities = productRepository.findByCreatedAtAfter(
     //          LocalDateTime.of(2024,1,1,0,0,0));
      //  List<ProductRepository> entities = productRepository.findByQuantityGreaterThanOrPriceLessThan(4,BigDecimal.valueOf(23.45));
    //  List<ProductEntity> entities = productRepository.findByTitleLike("%Choco%");
      List<ProductEntity> entities = productRepository.findByTitleContaining("Choco");
       System.out.println(entities);
   }

   @Test
    void getSingleFromRepository(){
        Optional<ProductEntity> productEntity = productRepository
                .findByTitleAndPrice("Nestle Chocolate", BigDecimal.valueOf(23.45));
        productEntity.ifPresent(System.out::println);
   }
}
