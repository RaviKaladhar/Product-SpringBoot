package com.example.product;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProductService productService;
    @BeforeEach
    @Test
    public void addProductTest()
    {
        assertEquals("knife",productService.addProduct(new ProductDTO(1,"knife","for cutting",200.0)).getName());
    }
    @Test
    public void getProductById() throws ProductException
    {
        assertEquals("knife",productService.getProduct(1).getName());
    }
    @Test
    public void deleteProductById() throws ProductException
    {
        assertThat(productService.deleteProduct(1).getPrice()).isEqualTo(200.0);
    }
}
