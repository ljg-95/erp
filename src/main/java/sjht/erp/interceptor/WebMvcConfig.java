package sjht.erp.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /* WebMvcConfigurer에 interceptor 추가  */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(interceptor())
                .addPathPatterns("/**") // interceptor 적용 url
                .excludePathPatterns("/api/login","/","/css/**", "/fonts/**", "/plugin/**", "/scripts/**"); // interceptor 적용 제외 url

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    /* 의존성 주입을 위해, @Bean으로 등록 */
    @Bean
    public Interceptor interceptor() {
        return new Interceptor();
    }
}
