package com.zoo.panda.service;

import com.zoo.panda.entity.User;

public interface UserService {
    User getByUsernameAndPassword(String userName, String passWord);
}
