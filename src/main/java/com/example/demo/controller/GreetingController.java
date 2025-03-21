package com.example.demo.controller;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.exception.GError;
import com.example.demo.common.exception.GException;
import com.example.demo.common.model.GResponse;
import com.example.demo.model.map.UserMap;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GreetingController {

    @Operation(summary = "기본 테스트")
	@GetMapping("/greeting")
	public ResponseEntity<GResponse> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		log.info("greeting 메소드 콜");

		return ResponseEntity.ok().body(new GResponse("0000", "greeting 리턴 메시지", name));
	}

	@Autowired
	private UserService userService;

	@Operation(summary = "사용자 정보 조회")
	@PostMapping("/user")
	public ResponseEntity<GResponse> user(@RequestParam String userId) {
		log.info("user 메소드 콜");
		Optional<UserMap> userMap = userService.getUser(userId);
        return ResponseEntity.ok().body(new GResponse("0000", userMap));
	}

}
