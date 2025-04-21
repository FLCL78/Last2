package balanceInAllThings.dao;

import balanceInAllThings.model.User;

import java.util.List;

public interface DAO {

    List<User> index();

    User show(Long id);

    void save(User user);

    void update(Long id, User updatedUser);

    void delete(Long id);
}