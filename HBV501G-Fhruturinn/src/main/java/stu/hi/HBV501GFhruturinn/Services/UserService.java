package stu.hi.HBV501GFhruturinn.Services;

import stu.hi.HBV501GFhruturinn.Persistence.Entities.User;

public interface UserService {
    User findByUsername(String username);

    User findByUserID(int id);

    User addUser(User user);

    void deleteUser(User user);
}
