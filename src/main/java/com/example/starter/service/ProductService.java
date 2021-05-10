package com.example.starter.service;

import com.example.starter.entity.Product;
import com.example.starter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public List<Product> getProductById(int id){
        return (List<Product>) repository.findById(id).orElse(null);
    }

    public List<Product> getProductByName(String name){
        return (List<Product>) repository.findByName(name);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed "+id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}