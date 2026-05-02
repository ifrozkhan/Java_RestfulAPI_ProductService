package com.example.product.Service;


import com.example.product.Entity.Product;
import com.example.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repo;
    public Product create(Product p)
    {
        return repo.save(p);
    }
    public List<Product> getAll()
    {
        return repo.findAll();
    }
    public Product getById(Long id)
    {
        return repo.findById(id).orElseThrow();
    }
    public Product update(Long id, Product req)
    {
        Product p=getById(id);
        p.setName(req.getName());
        p.setPrice(req.getPrice());
        p.setStock(req.getStock());
        return repo.save(p);
    }
    public void delete(Long id)
    {
        repo.deleteById(id);
    }
}
