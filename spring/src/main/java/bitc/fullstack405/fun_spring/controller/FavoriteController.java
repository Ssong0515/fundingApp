package bitc.fullstack405.fun_spring.controller;

import bitc.fullstack405.fun_spring.entity.FavoriteEntity;
import bitc.fullstack405.fun_spring.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // 좋아요 누른 유저 수
    @GetMapping("/favorite/user")
    public Object getFavoriteUserCount(@RequestBody int projectId) {
        projectId = favoriteService.getFavoriteUserCount(projectId);

        return projectId;
    }

    // 자신이 좋아요한 프로젝트 리스트
    @GetMapping("/favorite/project")
    public Object getFavoriteProject(@RequestBody int userId) {

        userId = favoriteService.getFavoriteProject(userId);

        return userId;
    }

    // 좋아요 생성
    @PostMapping("/favorite")
    public void createFavorite(@RequestBody FavoriteEntity favorite) {

        favoriteService.createFavorite(favorite);
    }

    // 좋아요 삭제
    @DeleteMapping("favorite/delete")
    public void deleteFavorite(@RequestBody FavoriteEntity favorite) {

        favoriteService.deleteFavorite(favorite);
    }
}
