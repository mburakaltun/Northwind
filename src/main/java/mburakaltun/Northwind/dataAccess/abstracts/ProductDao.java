package mburakaltun.Northwind.dataAccess.abstracts;

import mburakaltun.Northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
