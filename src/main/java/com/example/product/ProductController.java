package com.example.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductServiceInterface productService;
    @RequestMapping(method= RequestMethod.POST ,value = "/product")
    public ProductDTO addProduct(@RequestBody @Valid ProductDTO product)
    {
        return productService.addProduct(product);
    }
    @GetMapping("/product/{id}")
    public ProductDTO getProduct(@PathVariable Integer id) throws ProductException{
        return productService.getProduct(id);
    }
    @PutMapping("/product")
    public ProductDTO updateProduct(@RequestBody ProductDTO product) throws ProductException{
        return productService.updateProduct(product);
    }
    @DeleteMapping("/product/{id}")
    public ProductDTO deleteProduct(@PathVariable("id") Integer id) throws ProductException{
        return productService.deleteProduct(id);
    }
    @RequestMapping(method= RequestMethod.PATCH,value="/product")
    public ProductDTO patchProduct(ProductDTO pro) throws ProductException{
        return productService.patchProduct(pro);
    }
    @RequestMapping(value = "/product/sortedProducts",method = RequestMethod.GET)
    public List<ProductDTO> sortedProducts()
    {
        return productService.sortedProducts();
    }
}
