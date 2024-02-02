package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product){
        product.setProductId(String.valueOf(UUID.randomUUID()));
        productData.add(product);
        return product;
    }

    public Product edit(Product product){
        System.out.println("in edit "+product.getProductId());
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

    public boolean delete(String productId){
        Iterator<Product> iterator = productData.iterator();
        boolean deleteSuccess = false;
        while(iterator.hasNext()){
            if(iterator.next().getProductId().equals(productId)){
                iterator.remove();
                deleteSuccess=true;
            }
        }
        return deleteSuccess;
    }
}
