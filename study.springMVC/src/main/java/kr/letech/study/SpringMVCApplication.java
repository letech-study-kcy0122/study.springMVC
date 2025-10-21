/**
 * 
 */
package kr.letech.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * <pre>
 * 
 * </pre>
 * 
 * < 개정이력 >
 * 
 *  수정일			수정자			수정내용
 *  ------------------------------------------------
 *  2025-10-14		KCY				최초 생성
 */
@SpringBootApplication
@MapperScan(
//mybatis-context.xml에서 설정중인 기능 (MapperScannerConfigurer)
	basePackages = {"kr.letech.study"}
	, annotationClass = org.apache.ibatis.annotations.Mapper.class
)
public class SpringMVCApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringMVCApplication.class, args);
	}
}
