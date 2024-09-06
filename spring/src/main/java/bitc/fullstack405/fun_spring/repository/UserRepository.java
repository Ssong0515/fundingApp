package bitc.fullstack405.fun_spring.repository;


import bitc.fullstack405.fun_spring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUserIdAndUserPw(String userId, String userPw);

    UserEntity saveUser(UserEntity user);

    Boolean isUserInfo(String userId, String userPw);

    Boolean saveUser(String user, String userPw);

    UserEntity findUserIdForProfile(String userId);

    Boolean UserFindById(UserEntity user);

    UserEntity deleteByUser(String userId, String userPw);

    UserEntity logOutByUser(UserEntity user);

    UserEntity userDetail(UserEntity user);

    UserEntity findByUserId(String userId);
}
