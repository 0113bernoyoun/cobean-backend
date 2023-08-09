package com.cobean.backend.user.repository;

import com.cobean.backend.user.domain.User;

public interface UserRepository{

    User findByUserName(String userName);
}
