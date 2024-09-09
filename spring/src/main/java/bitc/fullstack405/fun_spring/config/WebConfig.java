package bitc.fullstack405.fun_spring.config;

import bitc.fullstack405.fun_spring.intercepter.LoginCheck;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//  인터셉터, excludePathPatterns()로 로그인 필요없는 뷰페이지 추가 가능
//  현재 세션 유지시간 1시간
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheck()).addPathPatterns("/loginSuccess"); // 로그인 필요 페이지 추가 가능
    }

//    // 파일 업로드 설정
//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setMaxUploadSize(10485760); // 10MB
//        resolver.setDefaultEncoding("utf-8");
//        return resolver;
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

// "/image/**" 경로로 요청이 들어오면 "C://FullStack405/react/team1_project/spring/image/"에서 이미지를 찾기
        registry.addResourceHandler("/image/**")
                .addResourceLocations("C://FullStack405/react/team1_project/spring/image/");

//        String path1 = "file:///" + fileUtil.getSaveFilePath();
//
//        registry.addResourceHandler("/image/**")
//                .addResourceLocations(path1);

    }
}