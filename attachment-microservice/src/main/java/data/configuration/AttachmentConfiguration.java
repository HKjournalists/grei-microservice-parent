package data.configuration;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;

/**
 * 配置文件初始化服务
 *
 * @author 刘佳兴
 * @version V1.0
 */
@Configuration
public class AttachmentConfiguration extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {


    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
        super.configurePathMatch(configurer);
    }

    




}
