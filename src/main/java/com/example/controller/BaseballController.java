package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Baseball;
import com.example.service.BaseballService;

@Controller
@RequestMapping("/baseball")
public class BaseballController {
	@Autowired
	private BaseballService baseballService;
	
	@RequestMapping("/showList")
	public String showList(Model model){
		List<Baseball> baseballList = baseballService.showList();
		if (baseballList.isEmpty()) {
			model.addAttribute("nothing", "データがありません");
			return "list";
		}
		model.addAttribute("baseballList", baseballList);
		return "list";
	}
	
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {
		Baseball baseball = baseballService.showDetail(id);
		String[] histories = baseball.getHistory().split("\n");
		model.addAttribute("baseball", baseball);
		model.addAttribute("histories", histories);
		
		return "detail";
	}
}
