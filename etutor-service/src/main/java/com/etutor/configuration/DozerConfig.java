package com.etutor.configuration;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

/**
 * @author huangyuan
 * @date 2019/8/26
 */
@Configuration
public class DozerConfig {

    @Bean
    public Mapper getDozerMapper() {
        //这里是配置文件的路径
        List<String> mappingFiles = Collections.singletonList("dozer/bean-mappings.xml");
        return DozerBeanMapperBuilder.create().withMappingFiles(mappingFiles).build();
    }

}