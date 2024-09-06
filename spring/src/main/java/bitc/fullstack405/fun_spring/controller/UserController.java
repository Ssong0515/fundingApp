
package bitc.fullstack405.fun_spring.controller;
import bitc.fullstack405.fun_spring.entity.UserEntity;
import bitc.fullstack405.fun_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {

    @Autowired
    private UserService loginService;

// 로그인 프로세스
    @PostMapping("/login")
    public Object loginProcess(@RequestBody String userId, @RequestBody String userPw) throws Exception {
        Boolean result = loginService.isUserInfo(userId, userPw);
        UserEntity user = null;

        if (userId != null && userPw != null && result) {
            user = loginService.findUserIdForProfile(userId);
        }
        if (user != null) {
            return false;
        }
        else {
            return true;
        }
        //  return loginService.findUserByUserIdAndPw(userId, userPw);
    }

// 로그아웃 프로세스
    @PostMapping("/logout")
    public Object logOutProcess(@RequestBody UserEntity user) throws Exception {
        loginService.logOutByUser(user);
//        System.out.println("로그아웃하시겠습니까?");
//        Object obj = new Object();
//        ? = "redirect:/login";

//        return obj;

        return true;
    }

// 화원가입 프로세스
    @PostMapping("/signIn")
    public Object signInProcess (@RequestBody UserEntity user) throws Exception {
        // DB에 받은 userId를 가진 user가 있는지 확인
        Boolean result = loginService.UserFindById(user);

        // 중복 o
        if (result == true) {
            return false;
        }
        // 중복 x
        else {
            loginService.saveUser(user);
            return true;
        }
    }

// 회원 상세보기
    @GetMapping("/user/{UserId}")
    public Object UserDetail(@RequestBody UserEntity user) throws Exception {
        user = loginService.getUserDetail(user);

        return user;
    }

//// 비밀번호 변경 프로세스
//    @PutMapping("/changePassword")
//    public Object changePassword(@RequestBody String userId, @RequestBody String userPw) throws Exception {
//        Boolean result =  loginService.saveUser(userId, userPw);
//
//        if (result == true) {
//            return "비밀번호 변경에 실패하였습니다.";
//        }
//        else {
//            loginService.saveUser(userId, userPw);
//            return "비밀번호가 변경되었습니다.";
//        }
//    }
//
//// 회원 탈퇴 프로세스
//    @DeleteMapping("/signOut")
//    public Object signOutProcess (@RequestBody String userId, @RequestBody String userPw) throws Exception {
//        loginService.deleteByUser(userId, userPw);
//
//        return "redirect:/login";
//    }
}