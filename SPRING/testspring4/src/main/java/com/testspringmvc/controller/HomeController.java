package com.testspringmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testspringmvc.domain.userDto;

@Controller
public class HomeController
{
	@RequestMapping("/")
	public String main()
	{
		return "home";
	}
	
	@PostMapping(value="/case1", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String case1(@RequestBody HashMap<String,Object> map)
	{
		System.out.println("mapping ok");
		
		String name = (String) map.get("name");
		String age = (String) map.get("age");
		
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map);
		
		return "성공";
	}
	
	@PostMapping(value="/case2")
	@ResponseBody
	public userDto case2(@RequestBody HashMap<String,Object> map)
	{
		System.out.println("case2 mapping ok");
		
		String id = (String) map.get("id");
		userDto dto = new userDto();
		dto.setId(id);
		
		return dto;
	}
	
	@PostMapping("/case3")
	@ResponseBody
	public List<userDto> case3(@RequestBody HashMap<String,Object> map)
	{
		System.out.println("case3 mapping ok");
		
		String id = (String) map.get("id");
		
		userDto dto1 = new userDto();
		dto1.setId(id);
		
		return new ArrayList<userDto>();
	}
}
