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

    public boolean edit(Product product){
        int index = findIndex(product.getProductId());
        Product existingProduct = productData.get(index);

        if (index==-1) return false;
        else{
            existingProduct.setProductQuantity(product.getProductQuantity());
            existingProduct.setProductName(product.getProductName());
            return true;
        }
    }

    public int findIndex(String productId){
        int index=0;
        for (Product productDatum : productData) {
            if (productDatum.getProductId().equals(productId)) {
                return index;
            }
            index += 1;
        }
        return -1;
    }


    public Iterator<Product> findAll(){
        return productData.iterator();
    }
    public boolean delete(String productId){
        int index = findIndex(productId);
        if (index==-1) return false;
        else {
            productData.remove(index);
            return true;
        }
    }
}
