package com.example.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class ProductMockRepositoryTest {
    @Autowired
    ProductServiceInterface productService;
    @MockBean
    ProductRepositoryInterface productRepository;
    @Test
    public void getProductTest() throws ProductException
    {
        given(productRepository.getProduct(100)).willReturn(new ProductDTO(100,"colgate","paste",25.00));
        assertEquals("colgate",productService.getProduct(100).getName());

    }
    @Test
    public void deleteProductTest() throws ProductException
    {
        given(productRepository.deleteProduct(200)).willThrow(new ProductException("no such product"));
        assertThrows(ProductException.class,()->productService.deleteProduct(200));
    }
}
