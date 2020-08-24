package com.his.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.app.model.UnlockUserAcc;

@Controller
public class UnlockAccController {
	
	@GetMapping(value = "/unlockUserAcc")
	public String displayUnlockAccForm(@RequestParam("email") String email, Model model) {
		model.addAttribute("email", email);

		UnlockUserAcc unlockAcc = new UnlockUserAcc();
		model.addAttribute("unlockAcc", unlockAcc);

		return "unlockAccForm";
	}

	@PostMapping("/unlockUserAcc")
	public String unlockUserAcc(@ModelAttribute("unlockAcc") UnlockUserAcc acc, Model model) {
		System.out.println(acc);

		// logic

		return "unlockAccForm";
	}
}
