package com.example.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.bind.annotation.PutMapping;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
    @Value("${local.server.port}")
    private int port;
    @Autowired
    private TestRestTemplate template;
    @BeforeEach
    public void init()
    {
        template.postForObject("http://localhost:"+port+"/product",new ProductDTO(1,"colgate","paste",20.0), ProductDTO.class);
    }
    @Test
    public void getProductByIdTest()
    {
        ProductDTO productById=template.getForObject("http://localhost:"+port+"/product/1", ProductDTO.class);
        assertThat(productById).isEqualTo(new ProductDTO(1,"colgate","paste",20.0));
    }
    @Test
    public void deleteProductByIdTest()
    {
        template.delete("http://localhost:"+port+"/product/1");
        assertThat(template.getForObject("http://localhost:" + port + "/product/1", String.class)).isEqualTo("product with id:"+1+"does not exist");
    }
    @Test
    public void updateProductTest()
    {
        template.put("http://localhost:"+port+"/product",new ProductDTO(2,"bat","for cricket",2000.0));
        assertThat(template.getForObject("http://localhost:" + port + "/product/2", String.class)).isEqualTo("product with id:"+2+"does not exist");
    }
}
