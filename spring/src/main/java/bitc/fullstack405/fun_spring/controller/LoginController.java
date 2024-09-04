
package bitc.fullstack405.fun_spring.controller;
import bitc.fullstack405.fun_spring.dto.User;
import bitc.fullstack405.fun_spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    //  로그인 프로세스
    @PostMapping("/login")
    public Object loginProcess(@RequestParam(name = "userId") String userId, @RequestParam(name = "userPw") String userPw) throws Exception {
        Boolean result = loginService.isUserInfo(userId, userPw);
        User user = null;

        if (userId != null && userPw != null && result) {
            user = loginService.findUserIdForProfile(userId);
        }
        if (user != null) {
            return "Login Successful";
        }
        else {
            return "Login Fail";
        }
        //  return loginService.findUserByUserIdAndPw(userId, userPw);
    }

//    //  로그아웃 프로세스
//    @RequestMapping("/logout")
//    public Object logout() throws Exception {
//
//    }

        //  화원가입 프로세스
        @PostMapping("/signIn")
        public Object signInProcess (@RequestParam(name = "user") User user) throws Exception {
        Boolean result = loginService.UserFindById(user);
                user = null;

        if (user != null && result) {
            return "Sign Up Successful";
        }
        else {
            return "Sign Up Fail";
        }
//       return loginService.saveUser(user);
        }

//    //  비밀번호 변경 프로세스
//    @PutMapping("/changePassword")
//    public Object changePassword(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, @RequestParam("userPwChk") String userPwChk) throws Exception {
//
//    }

    // 회원 탈퇴 프로세스
    @DeleteMapping("/signOut")
    public Object signOutProcess (@RequestParam(name = "userId") String userId, @RequestParam(name = "userPw") String userPw) throws Exception {
        return null;
    }
    }

