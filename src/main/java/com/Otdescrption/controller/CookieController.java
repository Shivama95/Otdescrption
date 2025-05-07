package com.Otdescrption.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Otdescrption.Dto.Cookie;
import com.Otdescrption.service.CookieService;

@RestController
@RequestMapping("/cookies")
public class CookieController {

	@Autowired
	private CookieService cookieService;

	@Value("${aceesstoken}")

	String accessToken;

	@PutMapping("/update")
	public void updateCookies(@RequestBody List<Cookie> cookies ) {

		for (Cookie cookie : cookies) {

			cookieService.updateCookieDescription(cookie, accessToken);

}
}
}
