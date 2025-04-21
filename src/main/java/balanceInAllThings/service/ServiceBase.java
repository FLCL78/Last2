package balanceInAllThings.service;

import balanceInAllThings.model.User;

import java.util.List;

public interface ServiceBase {

    List<User> index();

    User show(Long id);

    void save(User user);

    void update(Long id, User updatedUser);

    void delete(Long  id);
}

