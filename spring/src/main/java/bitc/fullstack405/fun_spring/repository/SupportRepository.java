package bitc.fullstack405.fun_spring.repository;

import bitc.fullstack405.fun_spring.entity.SupportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportRepository extends JpaRepository<SupportEntity, Integer> {

    int supportUserCount(int projectId);

    int getSupportingProject(int userId);

    void createSupport(SupportEntity support);

    void getSupportDelete(SupportEntity support);
}
