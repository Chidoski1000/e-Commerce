package com.example.demorestservice.controllers;

import com.example.demorestservice.models.Product;
import com.example.demorestservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product product1 = productService.addProduct(product);
        return ResponseEntity.ok(product1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.getProduct(id));

    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PutMapping("/")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/sort/{field}")
    public ResponseEntity<List<Product>> getSortedProduct(@PathVariable String field){
        return ResponseEntity.ok(productService.getSortedProduct(field));

    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public ResponseEntity<List<Product>> getAllProduct(@PathVariable int offset, @PathVariable int pageSize){
        return ResponseEntity.ok(productService.getPageableProduct(offset, pageSize).getContent());
    }

}
