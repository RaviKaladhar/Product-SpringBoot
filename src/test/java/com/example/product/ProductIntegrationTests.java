package com.example.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ProductIntegrationTests {
	@Autowired
    ProductController productController;
	@Test
	@BeforeEach
	void addProductTest() {
		assertEquals("knife",productController.addProduct(new ProductDTO(1,"knife","for cutting",230.0)).getName());
	}
	@Test
    void getProductTest() throws ProductException
	{
		assertEquals(productController.getProduct(1).getDescription(),"for cutting");
		assertThrows(ProductException.class,()->productController.getProduct(2));
	}
	@Test
	void deleteProductTest() throws ProductException
	{
		assertThat(productController.deleteProduct(1).getName()).isEqualTo("knife");
		assertThrows(ProductException.class,()->productController.deleteProduct(100));
	}
	@Test
	void updateProductTest()throws ProductException
	{
		assertEquals(productController.updateProduct(new ProductDTO(1,"knife","for cutting fruits and vegetables",200.0)).getName(),"knife");
		assertThrows(ProductException.class,()->productController.updateProduct(new ProductDTO(100,"Cooler","cooling",20000.0)));
	}
}
