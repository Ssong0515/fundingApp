package bitc.fullstack405.fun_spring.service;

import bitc.fullstack405.fun_spring.entity.SupportEntity;
import bitc.fullstack405.fun_spring.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportServiceImpl implements SupportService {

    @Autowired
    private SupportRepository supportRepository;

    @Override
    public int getSupportUserCount(int projectId) {

        return supportRepository.supportUserCount(projectId);
    }

    @Override
    public int getSupportingProject(int userId) {

        return supportRepository.getSupportingProject(userId);
    }

    @Override
    public void createSupport(SupportEntity support) {

        supportRepository.createSupport(support);
    }

    @Override
    public void getSupportDelete(SupportEntity support) {

        supportRepository.getSupportDelete(support);
    }
}
