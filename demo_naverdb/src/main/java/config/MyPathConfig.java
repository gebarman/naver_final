package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //servlet-context.xml파일 대신 현재 클래스가 설정을 대신할것
public class MyPathConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	//	registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/fullstack/upload/");
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///usr/mydir/upload/");
		//addResourceHandler(url).addResourceLocations(실제 파일 경로)
		///upload/파일명
	
	}
	
}
