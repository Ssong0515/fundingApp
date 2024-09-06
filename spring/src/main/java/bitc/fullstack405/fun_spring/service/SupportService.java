package bitc.fullstack405.fun_spring.service;

import bitc.fullstack405.fun_spring.entity.SupportEntity;

public interface SupportService {

    int getSupportUserCount(int projectId);

    int getSupportingProject(int userId);

    void getSupportDelete(SupportEntity support);

    void createSupport(SupportEntity support);
}
