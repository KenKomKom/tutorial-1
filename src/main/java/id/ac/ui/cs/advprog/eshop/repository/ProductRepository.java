package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private long productId = 0;
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product){
        product.setProductId(String.valueOf(productId++));
        productData.add(product);
        return product;
    }

    public Product edit(Product product){
        for (Product existingProduct :productData) {
            if (existingProduct.getProductId().equals(product.getProductId())) {
                existingProduct.setProductQuantity(product.getProductQuantity());
                existingProduct.setProductName(product.getProductName());
                return existingProduct;
            }
        }
        return null;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }
}
