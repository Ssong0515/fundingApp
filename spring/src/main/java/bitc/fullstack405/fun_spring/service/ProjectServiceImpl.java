package bitc.fullstack405.fun_spring.service;

import bitc.fullstack405.fun_spring.entity.ProjectEntity;
import bitc.fullstack405.fun_spring.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

//    @Autowired
//    private FileUtil fileUtil;

    // 상세보기
    @Override
    public ProjectEntity getProjectDetail(int projectId) {

        return projectRepository.findByProjectId(projectId);
    }

    // 리스트
    @Override
    public List<ProjectEntity> getProjectList() {

        return projectRepository.findAll();
    }

    // 인기순 리스트
    @Override
    public List<ProjectEntity> getProjectListRanking() {

        return projectRepository.findAll();
    }

    // 검색    (  임시로 만듦  )
    @Override
    public List<ProjectEntity> getProjectListSearch(String key) {

        return projectRepository.findAllByTitleStartingWith(key);
    }

    // 작성
    @Override
    public void getWriteProject(ProjectEntity project) {

//        String imgName = project.getImageName();
//        if (imgName == null || imgName.isEmpty()) {
//            imgName = "image_" + project.getProjectId();
//            project.setImageName(imgName);
//            projectRepository.save(project);
//        }
//        else {
//            fileUtil.deleteFile(imgName);
//        }

//        projectRepository.uploadFile(project);
        projectRepository.save(project);

    }


//    @Transactional
    @Override
    public void updateProject(ProjectEntity project) {
//        ProjectEntity p = projectRepository.findByProjectId(project.getProjectId());
//        p.setCurrentAmount(project.getCurrentAmount());
        projectRepository.save(project);
    }
}
