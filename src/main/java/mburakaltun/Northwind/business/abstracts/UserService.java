package mburakaltun.Northwind.business.abstracts;

import mburakaltun.Northwind.core.entities.User;
import mburakaltun.Northwind.core.utilities.results.DataResult;
import mburakaltun.Northwind.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
