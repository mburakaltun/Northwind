package mburakaltun.Northwind.business.concretes;

import mburakaltun.Northwind.business.abstracts.ProductService;
import mburakaltun.Northwind.core.utilities.results.DataResult;
import mburakaltun.Northwind.core.utilities.results.Result;
import mburakaltun.Northwind.core.utilities.results.SuccessDataResult;
import mburakaltun.Northwind.core.utilities.results.SuccessResult;
import mburakaltun.Northwind.dataAccess.abstracts.ProductDao;
import mburakaltun.Northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
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
        return new SuccessDataResult<List<Product>>(productDao.findAll(), "Products listed.");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product added");
    }

}
