package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> showList(){
		return hotelRepository.findAll();
	}
	
	public List<Hotel> searchHotel(Integer price) {
		return hotelRepository.searchHotel(price);
	}
}
