package mburakaltun.Northwind.business.concretes;

import mburakaltun.Northwind.business.abstracts.ProductService;
import mburakaltun.Northwind.core.utilities.results.DataResult;
import mburakaltun.Northwind.core.utilities.results.Result;
import mburakaltun.Northwind.core.utilities.results.SuccessDataResult;
import mburakaltun.Northwind.core.utilities.results.SuccessResult;
import mburakaltun.Northwind.dataAccess.abstracts.ProductDao;
import mburakaltun.Northwind.entities.DTOs.ProductWithCategoryDTO;
import mburakaltun.Northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(productDao.findAll(), "Products listed.");
    }

    @Override
    public DataResult<List<Product>> getAllSortedDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<>(productDao.findAll(sort), "Sorted products listed.");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product added");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<>(productDao.getByProductName(productName), "Products listed");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(productDao.getByProductNameAndCategory_CategoryId(productName, categoryId));
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(productDao.getByProductNameOrCategory_CategoryId(productName, categoryId));
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<>(productDao.getByCategory_CategoryIdIn(categories));
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<>(productDao.getByProductNameContains(productName));
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<>(productDao.getByProductNameStartsWith(productName));
    }

    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(productDao.getByNameAndCategory_CategoryId(productName, categoryId));
    }

    @Override
    public DataResult<List<ProductWithCategoryDTO>> getProductWithCategoryDetails() {
        return new SuccessDataResult<>(productDao.getProductWithCategoryDetails());
    }
}
