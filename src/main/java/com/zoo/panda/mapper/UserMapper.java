package com.zoo.panda.mapper;

import com.zoo.panda.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
  User getByUsernameAndPassword(@Param("userName") String userName, @Param("passWord") String passWord);
}
