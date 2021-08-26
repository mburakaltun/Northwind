package mburakaltun.Northwind.business.concretes;

import mburakaltun.Northwind.business.abstracts.CategoryService;
import mburakaltun.Northwind.core.utilities.results.DataResult;
import mburakaltun.Northwind.core.utilities.results.SuccessDataResult;
import mburakaltun.Northwind.dataAccess.abstracts.CategoryDao;
import mburakaltun.Northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<>(categoryDao.findAll(), "Categories listed");
    }
}
