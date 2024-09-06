package bitc.fullstack405.fun_spring.service;

import bitc.fullstack405.fun_spring.entity.UserEntity;

public interface UserService {
    UserEntity findUserByUserIdAndPw(String userId, String userPw);

    UserEntity saveUser(UserEntity user);

    Boolean isUserInfo(String userId, String userPw);

    UserEntity findUserIdForProfile(String userId);

    UserEntity findByUserId(String userId);

    Boolean UserFindById(UserEntity user);

    UserEntity logOutByUser(UserEntity user);

    UserEntity getUserDetail(UserEntity user);
}
