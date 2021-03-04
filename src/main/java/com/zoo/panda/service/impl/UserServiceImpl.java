package com.zoo.panda.service.impl;

import com.zoo.panda.entity.User;
import com.zoo.panda.mapper.UserMapper;
import com.zoo.panda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public User getByUsernameAndPassword(String userName, String passWord) {
    return userMapper.getByUsernameAndPassword(userName,passWord);
  }

}
