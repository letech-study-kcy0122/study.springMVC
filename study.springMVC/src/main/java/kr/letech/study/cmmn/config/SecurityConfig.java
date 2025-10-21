/**
 * 
 */
package kr.letech.study.cmmn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import kr.letech.study.cmmn.sec.handler.UserLoginFailHandler;
import kr.letech.study.cmmn.sec.handler.UserLoginSuccessHandler;

/**
 * 
 * <pre>
 * security-context.xml의 <s:...?> 태그들을 가져옴.
 * </pre>
 * 
 * < 개정이력 >
 * 
 *  수정일			수정자			수정내용
 *  ------------------------------------------------
 *  2025-10-14		KCY				최초 생성
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
    
    @Bean
    AuthorizationManager<RequestAuthorizationContext> anonymousOnly() {
      return (supplier, ctx) -> {
        Authentication a = supplier.get();
        boolean isAnon = (a == null) || (a instanceof AnonymousAuthenticationToken) || !a.isAuthenticated();
        return new AuthorizationDecision(isAnon);
      };
    }
    
	@Bean
	public SecurityFilterChain securityFilterChain(
			HttpSecurity http
			, AuthenticationProvider userLoginAuthenticationProvider
			, UserLoginSuccessHandler userLoginSuccessHandler
			, UserLoginFailHandler userLoginFailHandler
			) throws Exception {
		
		http
			//<s:intercept-url />
			.authorizeHttpRequests(auth -> 
				auth.antMatchers("/resources/**").permitAll()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.antMatchers("/cmmn/sec/loginForm", "/cmmn/user/insert").access(anonymousOnly())
					.antMatchers("/cmmn/user/**").authenticated()
					.antMatchers("/board/**").authenticated()
					.anyRequest().permitAll()
			)
			//<s:form-login />
			.formLogin(form -> 
				form.usernameParameter("userId")
					.passwordParameter("userPw")
					.loginProcessingUrl("/cmmn/sec/loginProc")
					.loginPage("/cmmn/sec/loginForm")
					.failureHandler(userLoginFailHandler)
					.successHandler(userLoginSuccessHandler)
					.permitAll() // Security는 기본 설정이 로그인된 사용자 접근만 허용??
			)
			//<s:logout />
			.logout(logout -> 
				logout.logoutUrl("/cmmn/sec/logout")
					  .logoutSuccessUrl("/")
					  .invalidateHttpSession(true)
					  .deleteCookies()
			)
			//<s:access-denied-handler />
			.exceptionHandling( exception ->
				exception
					.accessDeniedPage("/")
			)
			//<s:csrf />
			.csrf(csrf -> csrf.disable())
			//<s:authentication-manager />
			.authenticationProvider(userLoginAuthenticationProvider)
			.httpBasic(Customizer.withDefaults());
			
			
		
		return http.build();
	}
}
