package com.shmsacr.video_call_application.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
    private static final List<User> USERS_LIST = new ArrayList<>();
    public void register(User user){
        user.setStatus("online");
        USERS_LIST.add(user);
    }

    public User login(User user){
        var userIndex = IntStream.range(0,USERS_LIST.size())
                .filter(i-> USERS_LIST.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(()-> new RuntimeException("User Not found"));
        var cUser = USERS_LIST.get(userIndex);
        if (!cUser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("User Not found");
        }
        cUser.setStatus("online");
        return cUser;
    }
    public void logout(String email){
        var userIndex = IntStream.range(0,USERS_LIST.size())
                .filter(i-> USERS_LIST.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(()-> new RuntimeException("User Not found"));
        USERS_LIST.get(userIndex).setStatus("ofline");
    }

    public List<User> findAll() {
        return USERS_LIST;
    }
}
