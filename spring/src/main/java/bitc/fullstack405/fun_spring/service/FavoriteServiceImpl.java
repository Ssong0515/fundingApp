package bitc.fullstack405.fun_spring.service;

import bitc.fullstack405.fun_spring.entity.FavoriteEntity;
import bitc.fullstack405.fun_spring.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    // 프로젝트에 좋아요 누른 유저 수
    @Override
    public int getFavoriteUserCount(int projectId) {

        return favoriteRepository.findByFavoriteUserCount(projectId);
    }

    // 자신이 좋아요 누른 프로젝트 리스트
    @Override
    public int getFavoriteProject(int userId) {

        return favoriteRepository.getFavoriteProject(userId);
    }

    // 좋아요 생성
    @Override
    public void createFavorite(FavoriteEntity favorite) {

        favoriteRepository.createFavorite(favorite);
    }

    // 좋아요 삭제
    @Override
    public void deleteFavorite(FavoriteEntity favorite) {

        favoriteRepository.deleteFavorite(favorite);
    }
}
