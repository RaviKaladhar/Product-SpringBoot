package com.example.product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;
@SpringBootTest
public class productRepositoryTest {
    @Autowired
    ProductRepository productRepository;
    @Test
    @BeforeEach
    public void addProductTest(){
        assertEquals("","refrigerator",productRepository.addProduct(new ProductDTO(1,"refrigerator","to cool things",20000.0)).getName());
    }
    @Test
    public void getProductById() //throws ProductException
    {
        assertThrows(ProductException.class,()->productRepository.getProduct(2));
    }
    @Test
    public void deleteProductById() throws ProductException
    {
        assertEquals(null,productRepository.deleteProduct(1).getName(),"refrigerator");
    }
}
