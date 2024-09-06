package bitc.fullstack405.fun_spring.service;

import bitc.fullstack405.fun_spring.entity.UserEntity;
import bitc.fullstack405.fun_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findUserByUserIdAndPw(String userId, String userPw) {
        return userRepository.findByUserIdAndUserPw(userId, userPw);
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean isUserInfo(String userId, String userPw) {
        // 사용자가 있을 경우 true 를 반환하는 로직
        return userRepository.findByUserIdAndUserPw(userId, userPw) != null;
    }

    // 로그아웃
    @Override
    public UserEntity logOutByUser(UserEntity user) {
        return userRepository.logOutByUser(user);
    }

    // 상세보기
    @Override
    public UserEntity getUserDetail(UserEntity user) {
        return userRepository.userDetail(user);
    }

    @Override
    public UserEntity findUserIdForProfile(String userId) {
        return userRepository.findUserIdForProfile(userId);
    }

    @Override
    public UserEntity findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    // 회원가입
    @Override
    public Boolean UserFindById(UserEntity user) {
        return userRepository.UserFindById(user);
    }
}

