package Service;

import DAO.UserDAO;
import Entity.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(String name, String email) {
        User user = new User(name, email);
        userDAO.save(user);
    }

    public User getUserById(Long id) {
        return userDAO.findById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public void deleteUser(User user) {
        userDAO.delete(user);
    }
}