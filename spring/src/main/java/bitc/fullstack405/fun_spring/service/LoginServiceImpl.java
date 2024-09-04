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
    public User isUserInfo(String userId, String userPw) {
        return null;
    }

    @Override
    public User findUserIdForProfile(String userId) {
        return null;
    }
}
