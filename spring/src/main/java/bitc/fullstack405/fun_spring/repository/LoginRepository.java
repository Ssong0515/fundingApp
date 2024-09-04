package bitc.fullstack405.fun_spring.repository;

import bitc.fullstack405.fun_spring.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<User, Long> {
    User findByUserIdAndUserPw(String userId, String userPw);

    User saveUser(User user);

    Boolean isUserInfo(String userId, String userPw);

    Boolean saveUser(String user, String userPw);

    User findUserIdForProfile(String userId);

    Boolean UserFindById(User user);

    User deleteByUser(String userId, String userPw);

    User logOutByUser(User user);
}
