package io.userrolesecurity.mb.userrolesecurity.service;

import io.userrolesecurity.mb.userrolesecurity.dao.UserDaoService;
import io.userrolesecurity.mb.userrolesecurity.entity.UserEntity;
import io.userrolesecurity.mb.userrolesecurity.repository.RoleRepository;
import io.userrolesecurity.mb.userrolesecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
     private UserRepository userRepository;

    @Autowired
    private UserDaoService userDaoService;

    public UserEntity createUser(UserEntity userEntity) {

        userDaoService.users.add(userEntity);
            return userEntity;

    }


    public String deleteUserByName(String username) {

      return "user reomved successfully";
    }
}
