package io.userrolesecurity.mb.userrolesecurity.dao;

import io.userrolesecurity.mb.userrolesecurity.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    public static List<UserEntity> users=new ArrayList<>();
    private static int usersCount=0;

    static
    {
        users.add(new UserEntity(1, "John", "1234"));
    }
    public UserEntity findOneUser(Integer id) {
        Predicate<UserEntity> p = users -> (users.getUser_id()==id);
        return users.stream().filter(p).findFirst().orElse(null);
    }

    public UserEntity save(UserEntity userEntity) {
        userEntity.setUser_id(++usersCount);
        users.add(userEntity);
        return userEntity;
    }
}
