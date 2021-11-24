package stu.hi.HBV501GFhruturinn.Services.Implementation;

import stu.hi.HBV501GFhruturinn.Persistence.Entities.User;
import stu.hi.HBV501GFhruturinn.Persistence.Repositories.Repository;
import stu.hi.HBV501GFhruturinn.Services.UserService;

//this class is the middle man for contact between the Repository and the UserContoller
public class UserServiceImplementation implements UserService {


    @Override
    public User findByUsername(String userName) throws Exception {
        try {
            User user = Repository.findByUsername(userName);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByUserID(int idUser) throws Exception {
        User user = Repository.findByUserID(idUser);
        return user;
    }

    @Override
    public Boolean addUser(User user) throws Exception {

        if (Repository.addUser(user)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteUser(String userName) throws Exception {

        if (Repository.deleteUser(userName)) {
            return true;
        } else {
            return false;
        }
    }
}
