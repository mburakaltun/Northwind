package mburakaltun.Northwind.business.abstracts;

import mburakaltun.Northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
