package mburakaltun.Northwind.api.controllers;

import mburakaltun.Northwind.business.abstracts.ProductService;
import mburakaltun.Northwind.core.utilities.results.DataResult;
import mburakaltun.Northwind.core.utilities.results.Result;
import mburakaltun.Northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }
}
