package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Clothes;
import com.example.repository.ClothesRepository;

@Service
public class ClothesService {
	@Autowired
	ClothesRepository clothesRepository;
	
	public List<Clothes> searchClothes(Integer genre, String color){
		return clothesRepository.searchClothes(genre, color);
	}
}
