package chornarin.com.kh.Phone_Shop.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// @EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // Allowing others can access the application
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
        // registry.addMapping("http://localhost:3000/");
    }
    
    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //     // Map swagger-ui to /swagger-ui path
    //     registry.addResourceHandler("/swagger-ui/**")
    //             .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");

    //     // Map for other webjars resources
    //     registry.addResourceHandler("/webjars/**")
    //             .addResourceLocations("classpath:/META-INF/resources/webjars/");
    // }

}
