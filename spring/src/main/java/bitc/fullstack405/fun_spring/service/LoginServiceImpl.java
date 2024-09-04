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
        return false;
    }

    @Override
    public User findUserIdForProfile(String userId) {
        return null;
    }
}
