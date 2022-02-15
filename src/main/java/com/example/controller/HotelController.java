package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

@Controller
@RequestMapping("hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService; 
	
	@RequestMapping("")
	public String index() {
		return "hotel-list";
	}
	
	@RequestMapping("search")
	public String search(String price, Model model) {
		List<Hotel> hotelList = null;
		if(price.isEmpty()) {
			hotelList = hotelService.showList();
		}else {
			hotelList = hotelService.searchHotel(Integer.parseInt(price));
			
		}
		model.addAttribute("hotelList", hotelList);
		return "hotel-list";
	}
}
