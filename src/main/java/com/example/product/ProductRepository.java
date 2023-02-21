package com.example.product;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements ProductRepositoryInterface {
    Map<Integer, ProductDTO> map=new HashMap<>();

    @Override
    public ProductDTO addProduct(ProductDTO product) {
        map.put(product.getId(), product);
        return product;
    }

    @Override
    public ProductDTO getProduct(Integer id) throws ProductException{
        if(map.get(id)==null)
            throw new ProductException("product with id:"+id+"does not exist");
        return map.get(id);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO product) throws ProductException{
        ProductDTO productToBeUpdated=map.replace(product.getId(),product);
        if(productToBeUpdated==null)
            throw new ProductException("product:"+product+"does not exist to update");
        return product;
    }

    @Override
    public ProductDTO deleteProduct(Integer id) throws ProductException{
        ProductDTO productToBeDeleted=map.remove(id);
        if(productToBeDeleted==null)
            throw new ProductException("product with id:"+id+"does not exist to delete");
        return productToBeDeleted;
    }

    @Override
    public ProductDTO patchProduct(ProductDTO product) throws ProductException{
        ProductDTO productToBePatched=map.put(product.getId(),product);
        if(productToBePatched==null)
            throw new ProductException("Product:"+product+"not exist to patch");
        return productToBePatched;
    }
    public List<ProductDTO> sortedProducts()
    {
        Collection<ProductDTO> products=map.values();
        List<ProductDTO> list=new ArrayList<>(products);
        Collections.sort(list,(o1,o2)->Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId())));
        return list;

    }
}
