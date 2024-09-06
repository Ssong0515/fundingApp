package bitc.fullstack405.fun_spring.repository;

import bitc.fullstack405.fun_spring.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

    //find
    //save
    //delete

    int findByProjectId(int projectId);

    List<ProjectEntity> findByAllProject(String project);
}
