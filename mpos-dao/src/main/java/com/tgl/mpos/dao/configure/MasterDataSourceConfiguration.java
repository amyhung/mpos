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

/**
 * Configure your master database with mybatis.
 * If you have more then one database and want to use mybatis also, 
 * you can  create a class like this.
 * 
 * 如果有二個以上的 db 要採用 mybatis 時，必須要宣告兩個類別並各自設定，不能只針對第二個 DB 才去建立此類別
 * 因為當有兩個以上的 db 時，Spring Boot 目前不會去載入 app.properties 裡的 mybatis 設定
 * 
 * @author amyhung
 *
 */
//@Configuration
//@MapperScan(basePackages = MasterDataSourceConfiguration.Package, sqlSessionFactoryRef = "masterDataSourceConfiguration")
public class MasterDataSourceConfiguration {

	static final String Package = "com.tgl.mpos.dao.mapper.master";

	static final String MAPPER_LOCATION = "classpath:mybatis/mapper/master/*.xml";

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driverClassName}")
	private String driverClass;

	@Bean(name = "masterDataSource")
	public DataSource masterDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.driverClass);
		dataSource.setUrl(this.url);
		dataSource.setUsername(this.user);
		dataSource.setPassword(this.password);
		return dataSource;
	}

	@Bean(name = "masterTransactionManager")
	public DataSourceTransactionManager masterTransactionManager() {
		return new DataSourceTransactionManager((masterDataSource()));
	}

	@Bean(name = "masterDataSourceConfiguration")
	public SqlSessionFactory masterDataSourceConfiguration(@Qualifier("masterDataSource") DataSource masterDataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(masterDataSource);
		sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources(MasterDataSourceConfiguration.MAPPER_LOCATION));
		//sessionFactoryBean.setConfigLocation("");
		return sessionFactoryBean.getObject();
	}

}
