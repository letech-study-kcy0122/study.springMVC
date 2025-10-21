/**
 * 
 */
package kr.letech.study.cmmn.restTemplate.apiClient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import kr.letech.study.cmmn.restTemplate.envelope.Envelope;
import kr.letech.study.cmmn.utils.URIUtils;
import kr.letech.study.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
 *  2025-09-30		KCY				최초 생성
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SecurityApiClient {
	
	private final RestTemplate restTemplate;
	private static final String BASE_URL_USER = "http://localhost:8081/user-management";
	
//	// setter For XML Beans Settings...
//	public void setRestTemplate(RestTemplate restTemplate) {
//		this.restTemplate = restTemplate;
//	}
	
	public Envelope<UserVO> readUserDetail(String userId) {
		log.debug("▩▩▩ REST-API UserApiClient.readUserDetail() 호출.");
		
		String url = URIUtils.makeURI(BASE_URL_USER, "/users/{userId}");
		
		ResponseEntity<Envelope<UserVO>> response = 
				restTemplate.exchange(
						url
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<Envelope<UserVO>>() {}
						, userId
		);
		
		return response.getBody();
	}
	
	
}
