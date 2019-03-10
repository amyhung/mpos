package com.tgl.mpos.dao.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/com/tgl/mpos/dao/configure/app.properties")
//@ComponentScan(basePackages = { "com.tgl.mpos.dao" })
@MapperScan("com.tgl.mpos.dao.mapper.master")
public class DaoRegisterAutoConfiguration {

}
