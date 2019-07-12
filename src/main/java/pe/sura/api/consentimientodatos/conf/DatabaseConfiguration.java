package pe.sura.api.consentimientodatos.conf;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;
import pe.sura.api.consentimientodatos.util.SecretParameter;
import pe.sura.api.consentimientodatos.util.UtilEncryption;

@Configuration
@Slf4j
public class DatabaseConfiguration {

	public static final String JNDI = "java:/dsRecaAs400";
	
	@Autowired
	SecretConfiguration awsSecret;

	@Value("${spring.datasource.hikari.minimum-idle}")
	private int minimumIdle;

	@Value("${spring.datasource.hikari.maximum-pool-size}")
	private int maxPoolSize;

	@Primary
	@Bean(name = "sqlServerJdbcTemplate")
	public JdbcTemplate sqlServerJdbcTemplate(@Qualifier("dataSourceJNDIsqlServer") DataSource dataSourceJNDIsqlServer) {
		return new JdbcTemplate(dataSourceJNDIsqlServer);
	}

	@Bean(name = "dataSourceJNDIsqlServer")
	public DataSource getJNDIConectionSQLServer() {

		DataSource dataSource = null;
		try {
			Context initialContext = new InitialContext();

			dataSource = (DataSource) initialContext.lookup(DatabaseConfiguration.JNDI);
			if (dataSource != null) {
				log.info("Conecto al JNDI al datasource OnPremice");
			} else {
				dataSource = dataSourceSQLServer();
				log.info("Conecto Hikari SQLServer");
			}
		} catch (Exception e1) {
			log.error("Error al crear Invocar JNDI" + e1.getStackTrace());
			try {
				dataSource = dataSourceSQLServer();
				log.info("salio del hikari");
			} catch (Exception e2) {
				log.error("Error al crear JNDI Hikari SQLServer:" + e2);
			}

		}
		return dataSource;
	}
	
	@Bean
	public DataSource dataSourceSQLServer() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		SecretParameter aws = awsSecret.getSecretKey();

		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		hikariConfig.setJdbcUrl(
				UtilEncryption.decrypt(Base64.decodeBase64(aws.getCercaniabdCoreUrl()), aws.getKeyEncriptacion()));
		hikariConfig.setUsername(
				UtilEncryption.decrypt(Base64.decodeBase64(aws.getCercaniabdCoreUsr()), aws.getKeyEncriptacion()));
		hikariConfig.setPassword(
				UtilEncryption.decrypt(Base64.decodeBase64(aws.getCercaniabdCorePassw()), aws.getKeyEncriptacion()));
		hikariConfig.setMaximumPoolSize(maxPoolSize);
		hikariConfig.setMinimumIdle(minimumIdle);
		hikariConfig.setConnectionTestQuery("SELECT 1");
		hikariConfig.setPoolName("springHikariCP");

		return new HikariDataSource(hikariConfig);
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
		bean.setDatabase(Database.SQL_SERVER);
		bean.setGenerateDdl(true);
		bean.setShowSql(true);
		return bean;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			@Qualifier("dataSourceJNDIsqlServer") DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setJpaVendorAdapter(jpaVendorAdapter);
		bean.setPackagesToScan("pe.sura.api.consentimientodatos");
		return bean;
	}
}
