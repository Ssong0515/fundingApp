
package bitc.fullstack405.fun_spring.controller;
import bitc.fullstack405.fun_spring.entity.UserEntity;
import bitc.fullstack405.fun_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

// 로그인 프로세스
    @PostMapping("/login")
    public Object loginProcess(@RequestBody String userId, @RequestBody String userPw) throws Exception {
        Boolean result = userService.isUserInfo(userId, userPw);
        UserEntity user = null;

        if (userId != null && userPw != null && result) {
            user = userService.findByUserId(userId);
        }
        if (user != null) {
            return false;
        }
        else {
            return true;
        }
    }


// 화원가입 프로세스
    @PostMapping("/signIn")
    public Object signInProcess (@RequestBody UserEntity user) throws Exception {
        // DB에 받은 userId를 가진 user가 있는지 확인
        boolean result = userService.findByUserId(user.getUserId()) != null;

        // 중복 o
        if (result == true) {
            return false;
        }
        // 중복 x
        else {
            userService.saveUser(user);
            return true;
        }
    }

// 회원 상세보기
    @GetMapping("/user/{UserId}")
    public UserEntity UserDetail(@PathVariable(name = "userId") String userId ) throws Exception {
        UserEntity user = userService.findByUserId(userId);

        return user;
    }

}