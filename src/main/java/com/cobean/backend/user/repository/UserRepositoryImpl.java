package com.cobean.backend.user.repository;

import com.cobean.backend.common.exception.CustomException;
import com.cobean.backend.common.exception.ExceptionType;
import com.cobean.backend.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository{

    private final UserJpaRepository userJpaRepository;


    @Override
    public User findByUserName(String userName) {
        return userJpaRepository.findByUserName(userName).orElseThrow(() ->{
            log.error("해당 이름이 존재하지 않습니다. :: " + userName);
            return new CustomException(ExceptionType.USERNAME_NOT_FOUND);
        });
    }
}
