package com.example.product.Controllers;


import com.example.product.Entity.Product;
import com.example.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping
    public Product create(@RequestBody Product p)
    {
        return service.create(p);
    }
    @GetMapping
    public List<Product> all()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product one(@PathVariable Long id)
    {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,@RequestBody Product p)
    {
        return service.update(id,p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        service.delete(id);
    }
}