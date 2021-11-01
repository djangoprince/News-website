package stu.hi.HBV501GFhruturinn.Services.Implementation;

import stu.hi.HBV501GFhruturinn.Persistence.Entities.User;
import stu.hi.HBV501GFhruturinn.Services.UserService;

//this class is the middle man for contact between the Repository and the UserContoller
public class UserServiceImplementation implements UserService {


    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByUserID(int id) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }
}
