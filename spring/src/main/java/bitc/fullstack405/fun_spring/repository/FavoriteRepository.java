package bitc.fullstack405.fun_spring.repository;

import bitc.fullstack405.fun_spring.entity.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Integer> {


    void deleteFavorite(FavoriteEntity favorite);

    void createFavorite(FavoriteEntity favorite);

    int getFavoriteProject(int userId);

    int findByFavoriteUserCount(int projectId);
}
