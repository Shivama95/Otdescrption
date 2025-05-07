package com.Otdescrption.service;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Otdescrption.Dto.Cookie;

@Service
public class CookieService {

 private final RestTemplate restTemplate;

 public CookieService(RestTemplate restTemplate) {
 this.restTemplate = restTemplate;
}

 public void updateCookieDescription(Cookie cookie, String accessToken) {
String apiUrl = "https://app-de.onetrust.com/api/cookiemanager/v1/cookies";

 HttpHeaders headers = new HttpHeaders();
 headers.set("Authorization", "Bearer " + accessToken);
 HttpEntity<Cookie> entity = new HttpEntity<>(cookie, headers);
try {
 ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.PUT, entity, String.class);
} catch (Exception e) {
 e.printStackTrace();
}
 }
}
