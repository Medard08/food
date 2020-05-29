package org.polytech.persistence;

import org.polytech.buisness.User;

public interface UserRepository {

    void save(User user);

    void findById(Long id);
}
