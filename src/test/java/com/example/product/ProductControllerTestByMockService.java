package com.example.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTestByMockService {
    @Autowired
    ProductController productController;
    @MockBean
    ProductService productService;
    @Test
    @BeforeEach
    public void addProductTest()
    {
        when(productService.addProduct(new ProductDTO(1,"TV","entertainment",50000.0))).thenReturn(new ProductDTO(1,"TV","entertainment",50000.0));
        assertEquals("TV",productController.addProduct(new ProductDTO(1,"TV","entertainment",50000.0)).getName());
    }
    @Test
    public void getProductByIdTest() throws ProductException
    {
        when(productService.getProduct(200)).thenThrow(ProductException.class);
        assertThrows(ProductException.class,()->productController.getProduct(200));
    }
    @Test
    public void deleteProductByIdTest()throws ProductException
    {
        when(productService.deleteProduct(1)).thenReturn(new ProductDTO(1,"Ford","Company",Double.MAX_VALUE));
        assertEquals("Ford",productController.deleteProduct(1).getName());
    }
}
