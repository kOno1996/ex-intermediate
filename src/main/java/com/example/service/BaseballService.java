package com.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Baseball;
import com.example.repository.BaseballRepository;

@Service
public class BaseballService {
	@Autowired
	private BaseballRepository baseballRepository;
	
	public List<Baseball> showList(){
		return baseballRepository.findAll();
	}
	
	public Baseball showDetail(Integer id) {
		return baseballRepository.load(id);
	}
}
