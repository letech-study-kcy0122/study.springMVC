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
 *  2025-10-15		KCY				최초 생성
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class HomeApiClient {

	private final RestTemplate restTemplate;
	private static final String BASE_URL = "http://localhost:8081/cmmn-management";

	
	public Envelope<String> readServerTime() {
		log.debug("▩▩▩ REST-API HomeApiClient.readServerTime( ) 호출.");
		
		String url = BASE_URL + "/root";
		
		ResponseEntity<Envelope<String>> response = 
				restTemplate.exchange(
						url
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<Envelope<String>>() {}
		);
		
		return response.getBody();
	}
}













