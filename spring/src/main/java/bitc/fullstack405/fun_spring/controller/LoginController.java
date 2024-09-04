
package bitc.fullstack405.fun_spring.controller;
import bitc.fullstack405.fun_spring.dto.User;
import bitc.fullstack405.fun_spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //  로그인 프로세스
    @PostMapping("/login")
    public Object loginProcess(@RequestBody String userId, @RequestBody String userPw) throws Exception {
        Boolean result = loginService.isUserInfo(userId, userPw);
        User user = null;

        if (userId != null && userPw != null && result) {
            user = loginService.findUserIdForProfile(userId);
        }
        if (user != null) {
            return true;
        }
        else {
            return false;
        }
        //  return loginService.findUserByUserIdAndPw(userId, userPw);
    }

    //  로그아웃 프로세스
    @PostMapping("/logout")
    public Object logOutProcess(@RequestBody User user) throws Exception {
        loginService.logOutByUser(user);
//        System.out.println("로그아웃하시겠습니까?");
//        Object obj = new Object();
//        ? = "redirect:/login";

//        return obj;

        return "redirect:/login";
    }

        //  화원가입 프로세스
        @PostMapping("/signIn")
        public Object signInProcess (@RequestBody User user) throws Exception {
            // DB에 받은 userId를 가진 user가 있는지 확인
            Boolean result = loginService.UserFindById(user);

        /*
        user
        중복 -> user != null
        중복 x -> user == null

        null == false

         */

            // 중복 o
            if (result == true) {
                return "Already existed ID";
            }
            // 중복 x
            else {
                loginService.saveUser(user);
                return "Sign Up Successful";
            }
        }

//      비밀번호 변경 프로세스
    @PutMapping("/changePassword")
    public Object changePassword(@RequestBody String userId, @RequestBody String userPw) throws Exception {
        Boolean result =  loginService.saveUser(userId, userPw);

        if (result == true) {
            return "Change Password Fail";
        }
        else {
            loginService.saveUser(userId, userPw);
            return "Change Password Successful";
        }
    }

    // 회원 탈퇴 프로세스
    @DeleteMapping("/signOut")
    public Object signOutProcess (@RequestBody String userId, @RequestBody String userPw) throws Exception {
        loginService.deleteByUser(userId, userPw);

        return "redirect:/login";
    }
}