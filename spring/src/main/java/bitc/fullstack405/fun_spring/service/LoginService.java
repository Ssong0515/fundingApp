package bitc.fullstack405.fun_spring.service;

import bitc.fullstack405.fun_spring.dto.User;

public interface LoginService {
    User findUserByUserIdAndPw(String userId, String userPw);

    User saveUser(User user);

    Boolean isUserInfo(String userId, String userPw);

    User findUserIdForProfile(String userId);

    Boolean UserFindById(User user);

    User deleteByUser(String userId, String userPw);

    User logOutByUser(User user);

    Boolean saveUser(String userId, String userPw);

//    void execute(User user);
}