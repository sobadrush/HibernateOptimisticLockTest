package _00_Config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConfig.Pragma;

@Configuration
@ComponentScan(basePackages = "com.ctbc.model.dao.**")
@EnableTransactionManagement
public class RootConfig {

	@Autowired
	private Environment env;

	private Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;
			{
//				setProperty("hibernate.hbm2ddl.auto", "update");
				setProperty("hibernate.show_sql", "true");
				setProperty("hibernate.format_sql", "true");
				setProperty("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");
				// setProperty("hibernate.globally_quoted_identifiers", "true");
			}
		};
	}

	@Bean
	public DataSource driverManagerDs() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// 若無此設置，SQLite查日期會報錯
		// 參考：https://github.com/xerial/sqlite-jdbc/issues/88
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		SQLiteConfig sqLiteConfig = new SQLiteConfig();
		Properties props = sqLiteConfig.toProperties();
		props.setProperty(Pragma.DATE_STRING_FORMAT.pragmaName, "yyyy-MM-dd");
		
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setConnectionProperties(props);
		ds.setUrl("jdbc:sqlite:testDB.db");
		ds.setDriverClassName("org.sqlite.JDBC");
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(ds);
		sessionFactory.setPackagesToScan(new String[] { "com.ctbc.model.vo" });
		sessionFactory.setHibernateProperties(this.hibernateProperties());
//		sessionFactory.setEntityInterceptor(new MyInterceptor());
		return sessionFactory;
	}

	@Bean
	public PlatformTransactionManager txManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class);
		DataSource ds = ctx.getBean("driverManagerDs", DataSource.class);
		System.out.println(" @ 資料庫廠商 >>> " + ds.getConnection().getMetaData().getDatabaseProductName());
		ctx.close();
	}
}
