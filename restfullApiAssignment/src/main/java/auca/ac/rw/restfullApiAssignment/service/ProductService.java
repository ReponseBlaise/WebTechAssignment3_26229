package auca.ac.rw.restfullApiAssignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;
import auca.ac.rw.restfullApiAssignment.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public String addNewProduct(Product product) {
        productRepository.save(product);
        return "Product added successfully";
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public String updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            productRepository.save(product);
            return "Product updated successfully";
        }
        return "Product not found";
    }

    public String deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Product deleted successfully";
        }
        return "Product not found";
    }
     
    public List<Product> searchByCategory(String category) {
        List<Product> products = productRepository.findByCategory(category);
        if(products != null && !products.isEmpty()){
            return products;
        }
        else {
            return null;
        }
    }
    
    public List<Product> searchByBrand(String brand) {
        List<Product> products = productRepository.findByBrand(brand);
        if(products != null && !products.isEmpty()){
            return products;
        }
        else {
            return null;
        }
    }
   
   public List<Product> searchByCategoryAndBrand(String category, String brand) {
       List<Product> products = productRepository.findByCategoryAndBrand(category, brand);
       return (products != null && !products.isEmpty()) ? products : null;
   }
}