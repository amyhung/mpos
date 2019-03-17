package com.tgl.mpos.dao.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.tgl.mpos.dao.jdbc" })
@MapperScan("com.tgl.mpos.dao.mapper")
public class DaoRegisterAutoConfiguration {

}
