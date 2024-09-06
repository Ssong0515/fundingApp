
package bitc.fullstack405.fun_spring.controller;
import bitc.fullstack405.fun_spring.dto.User;
import bitc.fullstack405.fun_spring.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

// 로그인 프로세스
    @PostMapping("/login")
    public Object loginProcess(@RequestBody String userId, @RequestBody String userPw) throws Exception {
        Boolean result = loginService.isUserInfo(userId, userPw);
        User user = null;

        if (userId != null && userPw != null && result) {
            user = loginService.findUserIdForProfile(userId);
        }
        if (user != null) {
            return "로그인에 실패하였습니다.";
        }
        else {
            return "로그인 되었습니다.";
        }
        //  return loginService.findUserByUserIdAndPw(userId, userPw);
    }

// 로그아웃 프로세스
    @PostMapping("/logout")
    public Object logOutProcess(@RequestBody User user) throws Exception {
        loginService.logOutByUser(user);
//        System.out.println("로그아웃하시겠습니까?");
//        Object obj = new Object();
//        ? = "redirect:/login";

//        return obj;

        return "로그아웃 되었습니다.";
    }

// 화원가입 프로세스
    @PostMapping("/signIn")
    public Object signInProcess (@RequestBody User user) throws Exception {
        // DB에 받은 userId를 가진 user가 있는지 확인
        Boolean result = loginService.UserFindById(user);

        // 중복 o
        if (result == true) {
            return "이미 존재하는 아이디입니다.";
        }
        // 중복 x
        else {
            loginService.saveUser(user);
            return "회원가입에 성공하였습니다.";
        }
    }

// 비밀번호 변경 프로세스
    @PutMapping("/changePassword")
    public Object changePassword(@RequestBody String userId, @RequestBody String userPw) throws Exception {
        Boolean result =  loginService.saveUser(userId, userPw);

        if (result == true) {
            return "비밀번호 변경에 실패하였습니다.";
        }
        else {
            loginService.saveUser(userId, userPw);
            return "비밀번호가 변경되었습니다.";
        }
    }

// 회원 탈퇴 프로세스
    @DeleteMapping("/signOut")
    public Object signOutProcess (@RequestBody String userId, @RequestBody String userPw) throws Exception {
        loginService.deleteByUser(userId, userPw);

        return "redirect:/login";
    }

    ////////////////////////////////////////////////////////////////////

//    // 로그인 ex )
//    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
//    public String loginProcess(HttpServletRequest req, User user) throws Exception {
//        System.out.println("loginProcess()");
//
//        try {
//            req.setCharacterEncoding("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        String id = (String) req.getParameter("id");
//        String pw = (String) req.getParameter("pw");
//
//        System.out.println("id");
//        System.out.println("pw");
//
//        user.addAttribute("id", id);
//        user.addAttribute("pw", pw);
//
//        loginService.execute(user);
//
//        return "login";
//    }
//
//    // 회원가입 ex )
//    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
//    public String joinProcess(HttpServletRequest req, User user) throws Exception {
//        System.out.println("joinProcess()");
//
//        try {
//            req.setCharacterEncoding("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        String id = (String) req.getParameter("id");
//        String pw = (String) req.getParameter("pw");
//        String email = (String) req.getParameter("email");
//        String name = (String) req.getParameter("name");
//        String address = (String) req.getParameter("address");
//
//        System.out.println(id);
//        System.out.println(pw);
//        System.out.println(email);
//        System.out.println(name);
//        System.out.println(address);
//
//        user.addAttribute("id", id);
//        user.addAttribute("pw", pw);
//        user.addAttribute("email", email);
//        user.addAttribute("name", name);
//        user.addAttribute("address", address);
//
//        loginService.execute(user);
//
//        return "join";
//    }
}