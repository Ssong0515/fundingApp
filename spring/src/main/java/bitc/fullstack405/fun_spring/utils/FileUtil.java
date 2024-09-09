package bitc.fullstack405.fun_spring.utils;

import bitc.fullstack405.fun_spring.entity.ProjectEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileUtil {
    public ProjectEntity uploadFile(HttpServletRequest req, String imgFileName) throws ServletException, IOException {

        Part part = req.getPart("uploadFile");

        String savePath = getSaveFilePath();
        String savedFileName = imgFileName +".jpg";

        File f = new File(savePath);

        if (!imgFileName.isEmpty()) {
            part.write(savePath + File.separator + savedFileName );

            ProjectEntity projectEntity;
            projectEntity = new ProjectEntity();

            return projectEntity;
        }
        else {
            return null;
        }
    }

    public String getSaveFilePath() {
        File rootPath = new File("");
        String savePath = rootPath.getAbsolutePath();
        int subStdIdx = savePath.lastIndexOf('\\');
        savePath = savePath.substring(0, subStdIdx) + "\\Image\\";

        return savePath;
    }
}
