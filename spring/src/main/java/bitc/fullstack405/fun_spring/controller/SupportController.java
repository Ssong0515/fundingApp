package bitc.fullstack405.fun_spring.controller;

import bitc.fullstack405.fun_spring.entity.SupportEntity;
import bitc.fullstack405.fun_spring.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/support")
public class SupportController {

    @Autowired
    private SupportService supportService;

    // 후원한 유저 수
    @GetMapping("/support/user")
    public Object getSupportUserCount(@RequestBody int projectId) {
        projectId = supportService.getSupportUserCount(projectId);

        return projectId;
    }

    // 자신이 후원한 프로젝트 리스트
    @GetMapping("/support/project")
    public Object getSupportingProject(@RequestBody int userId) {
        userId = supportService.getSupportingProject(userId);

        return userId;
    }

    // 후원하기
    @PostMapping("/support")
    public void CreateSupport(@RequestBody SupportEntity support) {

        supportService.createSupport(support);
    }

    // 후원 취소
    @DeleteMapping("/support/delete")
    public void getSupportDelete(@RequestBody SupportEntity support) {

        supportService.getSupportDelete(support);
    }

}
