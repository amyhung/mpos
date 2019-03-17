package com.tgl.mpos.api.base;

import org.springframework.context.annotation.PropertySource;


/*
 * base controller for all Restful controllers
 * @author amyhung
 */
@PropertySource("classpath:/props/${spring.profiles.active}/app.properties")
public class BaseController {

}
