package com.example.product;

import java.util.List;

public interface ProductRepositoryInterface {
    public ProductDTO addProduct(ProductDTO product);
    public ProductDTO getProduct(Integer id)throws ProductException;
    public ProductDTO updateProduct(ProductDTO product)throws ProductException;
    public ProductDTO deleteProduct(Integer id)throws ProductException;
    public ProductDTO patchProduct(ProductDTO product)throws ProductException;
    public List<ProductDTO> sortedProducts();
}
