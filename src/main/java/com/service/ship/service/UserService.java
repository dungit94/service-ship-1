package com.service.ship.service;

import com.service.ship.model.user.UserModel;

public interface UserService {
    void save(UserModel user);

    UserModel findByUserName(String userName);
}
