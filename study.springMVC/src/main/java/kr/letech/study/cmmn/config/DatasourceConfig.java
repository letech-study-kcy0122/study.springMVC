/**
 * 
 */
package kr.letech.study.cmmn.config;

import org.springframework.context.annotation.Configuration;

/**
 * 
 * <pre>
 * datasource-context.xml 의 Bean객체화.
 * datasource, sqlSessionFactory, sqlSessionTemplate을
 * 커스텀할 수 있다.
 * 
 * application.properties의 #Datasource 참조.
 * </pre>
 * 
 * < 개정이력 >
 * 
 *  수정일			수정자			수정내용
 *  ------------------------------------------------
 *  2025-10-14		KCY				최초 생성
 */
@Configuration
public class DatasourceConfig {

//	@Bean
//	public ConfigurationCustomizer mybatisConfig() {
//		return configuration -> {
//			configuration.setMapUnderscoreToCamelCase(true);
//			configuration.setDefaultFetchSize(200);
//		};
//	}
	
//	@Bean
//	public SqlSessionFactoryBeanCustomizer factoryBeanCustomizer() {
//		return factoryBean -> {
//			
//		};
//	}
	
//	@Bean
//	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
//		return new SqlSessionTemplate(factory, ExecutorType.BATCH);
//	}
	
}
