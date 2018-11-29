/*package priv.dengjl.configurer;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import priv.dengjl.converter.MyMessageConverter;

@Component
@Configuration
public class WebConfig1 implements WebMvcConfigurer  {

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		MyMessageConverter converter = new MyMessageConverter();  
        converters.add(converter);  
	}
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //映射路径和页面
        registry.addViewController("/convert").setViewName("/convert");
	}
	
}
*/