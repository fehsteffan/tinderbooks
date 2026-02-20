package com.tinder.books.services;


import com.tinder.books.model.UserModel;
import com.tinder.books.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class UserServices {


    public final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserModel> list(){
        return userRepository.findAll();
    }

    public UserModel findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Not found Exception"));
    }

    public UserModel create(UserModel user) {
        return userRepository.save(user);
    }

    public UserModel upDate(UserModel user){
        UserModel entity = userRepository.findById(user.getId())
                .orElseThrow(()-> new IllegalArgumentException("Not found"));

        entity.setId(user.getId());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setAnddress(user.getAnddress());
        entity.setGender(user.getGender());

        return userRepository.save(entity);
    }

    public void delete(Long id) {
       UserModel user = userRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Not found"));

               userRepository.delete(user);

    }

}
