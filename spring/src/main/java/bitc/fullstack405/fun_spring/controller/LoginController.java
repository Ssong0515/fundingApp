
package bitc.fullstack405.fun_spring.controller;
import bitc.fullstack405.fun_spring.dto.User;
import bitc.fullstack405.fun_spring.service.LoginService;
import bitc.fullstack405.fun_spring.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    //  로그인 프로세스
    @PostMapping("/login")
    public Object loginProcess(@RequestParam(name = "userId") String userId, @RequestParam(name = "userPw") String userPw) throws Exception {

//        User result = loginService.isUserInfo(userId, userPw);
//        User user = loginService.findUserIdForProfile(userId);
//
//        if (userId != null && userPw != null && result == 1) {
//            if (userId.get(0) != null && userId.get(0).equals("Y")) {
//                CookieUtil.makeCookie(user, "userId", userId, (60 * 60 * 24 * 7));
//            } else {
//                CookieUtil.deleteCookie(user, "userId");
//            }
//
////            User user = loginService.findUserIdForProfile(userId);
//            var deleted = user.getDeletedYn();
//        }
        //  return loginService.findUserByUserIdAndPw(userId, userPw);
        return "Login Successful";
    }

//    //  로그아웃 프로세스
//    @RequestMapping("/logout")
//    public Object logout() throws Exception {
//
//    }

        //  화원가입 프로세스
        @PostMapping("/signIn")
        public Object signInProcess (@RequestParam(name = "user") User user) throws Exception {

        return "Sign In Successful";
//       return loginService.saveUser(user);
        }

//    //  비밀번호 변경 프로세스
//    @PutMapping("/changePassword")
//    public Object changePassword(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, @RequestParam("userPwChk") String userPwChk) throws Exception {
//
//    }
    }

