package bitc.fullstack405.fun_spring.repository;

import bitc.fullstack405.fun_spring.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<User, Long> {
    User findByUserIdAndUserPw(String userId, String userPw);
}
