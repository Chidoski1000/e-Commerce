package com.example.demorestservice.services.impl;

import com.example.demorestservice.models.Product;
import com.example.demorestservice.repositories.ProductRepository;
import com.example.demorestservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
//        Pageable pageable =
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long productId) {
        if(productRepository.findById(productId).isPresent())
            return productRepository.findById(productId).get();
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        if (getProduct(product.getId()) != null)
            return productRepository.save(product);
        return null;
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        if (getProduct(productId) != null) {
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getSortedProduct(String field) {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    @Override
    public Page<Product> getPageableProduct(int offset, int pageSize) {
        return productRepository.findAll(PageRequest.of(offset, pageSize));
    }


}
