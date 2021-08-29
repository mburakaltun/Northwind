package mburakaltun.Northwind.business.concretes;

import mburakaltun.Northwind.business.abstracts.UserService;
import mburakaltun.Northwind.core.dataAccess.UserDao;
import mburakaltun.Northwind.core.entities.User;
import mburakaltun.Northwind.core.utilities.results.DataResult;
import mburakaltun.Northwind.core.utilities.results.Result;
import mburakaltun.Northwind.core.utilities.results.SuccessDataResult;
import mburakaltun.Northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult("User added successfully");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<>(userDao.findByEmail(email));
    }
}
