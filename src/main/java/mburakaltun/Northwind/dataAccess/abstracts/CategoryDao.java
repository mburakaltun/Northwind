package mburakaltun.Northwind.dataAccess.abstracts;

import mburakaltun.Northwind.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}
