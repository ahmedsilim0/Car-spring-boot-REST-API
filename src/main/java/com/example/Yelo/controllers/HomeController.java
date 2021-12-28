package com.example.Yelo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/greeting")
	public String Hello() {
		return "hello world";
	}

	@GetMapping(value = "/")
	public String greetinWithName() {
		return "hello and welcome to my springboot app";
	}
}
