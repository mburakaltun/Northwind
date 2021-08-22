package mburakaltun.Northwind.business.concretes;

import mburakaltun.Northwind.business.abstracts.ProductService;
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
    public List<Product> getAll() {
        return productDao.findAll();
    }
}
