package org.polytech.buisness;

import org.polytech.persistence.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        this.userRepository.save(user);
    }
}
