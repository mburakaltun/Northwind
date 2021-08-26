package mburakaltun.Northwind.business.abstracts;

import mburakaltun.Northwind.core.utilities.results.DataResult;
import mburakaltun.Northwind.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    DataResult<List<Category>> getAll();
}
