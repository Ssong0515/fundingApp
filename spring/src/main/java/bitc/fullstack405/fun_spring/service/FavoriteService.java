package bitc.fullstack405.fun_spring.service;

import bitc.fullstack405.fun_spring.entity.FavoriteEntity;

public interface FavoriteService {

    int getFavoriteUserCount(int projectId);

    int getFavoriteProject(int userId);

    void createFavorite(FavoriteEntity favorite);

    void deleteFavorite(FavoriteEntity favorite);

}
