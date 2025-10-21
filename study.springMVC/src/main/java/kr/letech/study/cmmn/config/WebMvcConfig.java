/**
 * 
 */
package kr.letech.study.cmmn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/user-profile/**")
				.addResourceLocations("file:///D:/java/eclipse/eGovFrameDev-4.0.0-64bit/eclipse/study.SpringMVC/user/");
	}

	// @Configuration 클래스 어딘가
	@Bean
	public nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect layoutDialect() {
	  return new nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect();
	}
	
//	
//	@Bean
//	public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine engine) {
//		ThymeleafViewResolver vr = new ThymeleafViewResolver();
//		vr.setTemplateEngine(engine);
//		vr.setCharacterEncoding("UTF-8");
//		vr.setOrder(1);
//		vr.setViewNames(new String[] {"*.html"});
//		return vr;
//	}
//	
//	@Bean
//	public InternalResourceViewResolver jspViewResolver() {
//		InternalResourceViewResolver vr = new InternalResourceViewResolver();
//		vr.setPrefix("/WEB-INF/");
//		vr.setSuffix(".jsp");
//		vr.setViewClass(JstlView.class);
//		vr.setOrder(2);
//		
////		vr.setViewNames("*.jsp");
//		return vr;
//	}
//	

// 1014_Thymeleaf로 전환
//	@Bean
//	public TilesConfigurer tilesConfigurer() {
//		TilesConfigurer cfg = new TilesConfigurer();
//		cfg.setDefinitions("/WEB-INF/spring/tiles-define.xml");
//		return cfg;
//	}
//
//	@Bean
//	public UrlBasedViewResolver tilesViewResolver() {
//		UrlBasedViewResolver vr = new UrlBasedViewResolver();
//		vr.setViewClass(org.springframework.web.servlet.view.tiles3.TilesView.class);
//		vr.setOrder(1);
//		return vr;
//	}

// 1014_Thymeleaf의 템플릿엔진, 뷰리졸버 등은 starter가 제공함.
//	@Bean
//	public SpringResourceTemplateResolver templateResolver() {
//		// SpringResourceTemplateResolver automatically integrates with Spring's own
//		// resource resolution infrastructure, which is highly recommended.
//		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//		templateResolver.setApplicationContext(this.applicationContext);
//		templateResolver.setPrefix("/WEB-INF/templates/");
//		templateResolver.setSuffix(".html");
//		// HTML is the default value, added here for the sake of clarity.
//		templateResolver.setTemplateMode(TemplateMode.HTML);
//		// Template cache is true by default. Set to false if you want
//		// templates to be automatically updated when modified.
//		templateResolver.setCacheable(true);
//		return templateResolver;
//	}
//
//	@Bean
//	public SpringTemplateEngine templateEngine() {
//		// SpringTemplateEngine automatically applies SpringStandardDialect and
//		// enables Spring's own MessageSource message resolution mechanisms.
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver());
//		// Enabling the SpringEL compiler with Spring 4.2.4 or newer can
//		// speed up execution in most scenarios, but might be incompatible
//		// with specific cases when expressions in one template are reused
//		// across different data types, so this flag is "false" by default
//		// for safer backwards compatibility.
//		templateEngine.setEnableSpringELCompiler(true);
//		return templateEngine;
//	}
//
//	@Bean
//	public ThymeleafViewResolver viewResolver() {
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		viewResolver.setTemplateEngine(templateEngine());
//		// NOTE 'order' and 'viewNames' are optional
//		viewResolver.setOrder(1);
//		viewResolver.setViewNames(new String[] { ".jsp", ".html" });
//		return viewResolver;
//	}

}
