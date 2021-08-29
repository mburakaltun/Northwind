package mburakaltun.Northwind.api.controllers;

import mburakaltun.Northwind.business.abstracts.ProductService;
import mburakaltun.Northwind.core.utilities.results.DataResult;
import mburakaltun.Northwind.core.utilities.results.Result;
import mburakaltun.Northwind.entities.DTOs.ProductWithCategoryDTO;
import mburakaltun.Northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        return productService.getAll(pageNo-1, pageSize);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("/getAllSortedDesc")
    public DataResult<List<Product>> getAllSortedDesc() {
        return productService.getAllSortedDesc();
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName, @RequestParam int categoryId) {
        return productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName, @RequestParam int categoryId) {
        return productService.getByProductNameOrCategoryId(productName, categoryId);
    }

    @GetMapping("/getByCategoryIdIn")
    public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories) {
        return productService.getByCategoryIdIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName, @RequestParam int categoryId) {
        return productService.getByNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getProductWithCategoryDetails")
    DataResult<List<ProductWithCategoryDTO>> getProductWithCategoryDetails() {
        return productService.getProductWithCategoryDetails();
    }
}
