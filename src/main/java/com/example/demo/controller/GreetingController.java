package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.exception.GError;
import com.example.demo.common.exception.GException;
import com.example.demo.common.model.GResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GreetingController {

	@GetMapping("/greeting")
	public ResponseEntity<GResponse> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		log.info("greeting 메소드 콜");

        return ResponseEntity.ok().body(new GResponse("0000", "greeting 리턴 메시지", name));
	}

}
