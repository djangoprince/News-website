package stu.hi.HBV501GFhruturinn.Services;

import stu.hi.HBV501GFhruturinn.Persistence.Entities.User;

public interface UserService {
    User findByUsername(String username) throws Exception;

    User findByUserID(int id) throws Exception;

    Boolean addUser(User user) throws Exception;

    Boolean deleteUser(String userName) throws Exception;
}
