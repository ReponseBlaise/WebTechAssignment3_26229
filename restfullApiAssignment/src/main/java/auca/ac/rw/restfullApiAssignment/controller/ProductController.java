package auca.ac.rw.restfullApiAssignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;
import auca.ac.rw.restfullApiAssignment.service.ProductService;

@RestController
@RequestMapping("/api/products")    
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
        String saveProduct = productService.addNewProduct(product);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        String result = productService.updateProduct(id, product);
        if (result.equals("Product updated successfully")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        String result = productService.deleteProduct(id);
        if (result.equals("Product deleted successfully")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchByCategory(@RequestParam String category) {
       List<Product> getProducts = productService.searchByCategory(category);
       if(getProducts !=null && !getProducts.isEmpty()){
        return new ResponseEntity<>(getProducts, HttpStatus.OK);
       }
       else {
        return new ResponseEntity<>("No products found in this category", HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping(value="/searchByBrand", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchByBrand(@RequestParam String brand) {
        List<Product> getProducts = productService.searchByBrand(brand);
        if(getProducts !=null && !getProducts.isEmpty()){
         return new ResponseEntity<>(getProducts, HttpStatus.OK);
        }
        else {
         return new ResponseEntity<>("No products found for this brand", HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping(value="/searchByCategoryAndBrand", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchByCategoryAndBrand(
            @RequestParam(required = false) String category, 
            @RequestParam(required = false) String brand) {
        List<Product> getProducts = productService.searchByCategoryAndBrand(category, brand);
        if(getProducts !=null && !getProducts.isEmpty()){
         return new ResponseEntity<>(getProducts, HttpStatus.OK);
        }
        else {
         return new ResponseEntity<>("No products found", HttpStatus.NOT_FOUND);
        }
    }
}
