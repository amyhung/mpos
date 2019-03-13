package com.tgl.mpos.service.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

//@PropertySource("classpath:/com/tgl/mpos/service/configure/app.properties")
@PropertySource("classpath:/META-INF/app.properties")
@ComponentScan(basePackages = { "com.tgl.mpos.service" })
public class ServiceRegisterAutoConfiguration {

	
}
