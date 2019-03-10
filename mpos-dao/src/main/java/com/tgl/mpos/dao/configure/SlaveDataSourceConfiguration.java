package com.tgl.mpos.dao.configure;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan(basePackages = SlaveDataSourceConfiguration.Package, sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveDataSourceConfiguration {

	static final String Package = "com.tgl.mpos.dao.mapper.slave";

	static final String MAPPER_LOCATION = "classpath:mybatis/mapper/slave/*.xml";

	@Value("${spring.datasource.slave.url}")
	private String url;

	@Value("${spring.datasource.slave.username}")
	private String user;

	@Value("${spring.datasource.slave.password}")
	private String password;

	@Value("${spring.datasource.slave.driverClassName}")
	private String driverClass;

	@Bean(name = "slaveDataSource")
	public DataSource slaveDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.driverClass);
		dataSource.setUrl(this.url);
		dataSource.setUsername(this.user);
		dataSource.setPassword(this.password);
		return dataSource;
	}

	@Bean(name = "slaveTransactionManager")
	public DataSourceTransactionManager slaveTransactionManager() {
		return new DataSourceTransactionManager((slaveDataSource()));
	}

	@Bean(name = "slaveSqlSessionFactory")
	public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(slaveDataSource);
		sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources(SlaveDataSourceConfiguration.MAPPER_LOCATION));
		//sessionFactoryBean.setConfigLocation("");
		return sessionFactoryBean.getObject();
	}

}
