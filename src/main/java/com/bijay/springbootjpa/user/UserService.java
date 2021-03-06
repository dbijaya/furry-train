package com.bijay.springbootjpa.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll()
        .forEach(users::add);
        return users;
    }

	public Optional<User> getUser(Integer id) {
		return userRepository.findById(id);
    }

	public void addUser(User user) {
        userRepository.save(user);
    }
    
    public void updateUser(User user, Integer id){
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
