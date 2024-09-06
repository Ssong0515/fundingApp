package bitc.fullstack405.fun_spring.service;

import bitc.fullstack405.fun_spring.dto.User;
import bitc.fullstack405.fun_spring.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;


    @Override
    public User findUserByUserIdAndPw(String userId, String userPw) {
        return loginRepository.findByUserIdAndUserPw(userId, userPw);
    }

    @Override
    public User saveUser(User user) {
        return loginRepository.save(user);
    }

    @Override
    public Boolean isUserInfo(String userId, String userPw) {
        // 사용자가 있을 경우 true 를 반환하는 로직
        return loginRepository.findByUserIdAndUserPw(userId, userPw) != null;
    }

    // 로그아웃
    @Override
    public User logOutByUser(User user) {
        return loginRepository.logOutByUser(user);
    }

    // 비밀번호 변경
    @Override
    public Boolean saveUser(String userId, String userPw) {
        return loginRepository.saveUser(userId, userPw);
    }

//     ex
//    @Override
//    public void execute(User user) {
//
//    }

    @Override
    public User findUserIdForProfile(String userId) {
        return loginRepository.findUserIdForProfile(userId);
    }

    // 회원가입
    @Override
    public Boolean UserFindById(User user) {
        return loginRepository.UserFindById(user);
    }

    // 회원탈퇴
    @Override
    public User deleteByUser(String userId, String userPw) {
        return loginRepository.deleteByUser(userId, userPw);
    }
}
