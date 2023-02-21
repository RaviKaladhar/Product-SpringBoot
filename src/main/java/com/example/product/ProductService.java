package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface{
    @Autowired
    ProductRepositoryInterface productRepository;
    @Override
    public ProductDTO addProduct(ProductDTO product)
    {
        return productRepository.addProduct(product);
    }
    @Override
    public ProductDTO getProduct(Integer id) throws ProductException{
        return productRepository.getProduct(id);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO product) throws ProductException{
        return productRepository.updateProduct(product);
    }

    @Override
    public ProductDTO deleteProduct(Integer id) throws ProductException{
        return productRepository.deleteProduct(id);
    }

    @Override
    public ProductDTO patchProduct(ProductDTO product) throws ProductException{
        return productRepository.patchProduct(product);
    }

    @Override
    public List<ProductDTO> sortedProducts() {
        return productRepository.sortedProducts();
    }
}
