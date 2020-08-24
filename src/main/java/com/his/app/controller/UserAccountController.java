package com.his.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import com.his.app.model.UserAccountModel;
import com.his.app.service.UserAccountService;

@Controller
public class UserAccountController {
	@Autowired 
	UserAccountService userAccService;
	
	@GetMapping(value= {"/","/createUser"})
	public String loadUserForm(Model model) {
		
		UserAccountModel userAccModel = new UserAccountModel();
		model.addAttribute("userAccModel", userAccModel);
		initializeFormValue(model);
		System.out.println("from loadUserForm :"+userAccModel);
		return "loadForm";	
	}

	@PostMapping(value= "/createUser")
	public String createUserAccount(@ModelAttribute("userAccModel")UserAccountModel userAccModel, Model model) {
		boolean userCreated=userAccService.createUser(userAccModel);
		
		if(userCreated) {
			model.addAttribute("succMsg", "User Created Succefully");
		}else {
		model.addAttribute("failMsg", "User Failed To Create");
	}
		//initializeFormValue(model);
		
		return "unlock";
		
	}
	public void initializeFormValue(Model model) {
		List<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		model.addAttribute("gender", gender);
		
		List<String> role = new ArrayList<String>();
		role.add("Admin");
		role.add("CaseWorker");
		model.addAttribute("role", role);

	}
	@GetMapping("/view")
	public String viewAllUsers(Model model) {
		List<UserAccountModel> userList = userAccService.getAllUsers();
		model.addAttribute("userList", userList);
		System.out.println("all users::"+userList);
		return "viewUsers";
		
	}
	@RequestMapping("/editUser")
	public String editUser( @RequestParam("userId") Long userId ,Model model) {
		UserAccountModel c = userAccService.getUserById(userId);
		model.addAttribute("userModel", c);
		return "loadForm";
		
	}
	@DeleteMapping("/deleteUser/{userId}")
	public void delete(@PathVariable("userId") Long userId) {
		userAccService.deleteUser(userId);
	}
}