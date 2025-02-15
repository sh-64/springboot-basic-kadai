package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;



@Controller
public class ContactFormController {
	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("contactForm", new ContactForm());
		return "contactFormView";
	}
	
	 @PostMapping("/confirm")  
	    public String confirmForm(@Validated ContactForm contactForm, BindingResult bindingResult, Model model) {  
	        if (bindingResult.hasErrors()) {  
	            // エラーがある場合、元のフォームにリダイレクト  
	            return "contactFormView"; // contactFormView.html  
	        }  
	        // エラーがない場合、確認画面にデータを渡す  
	        model.addAttribute("contactForm", contactForm);  
	        return "confirmView"; // confirmView.html  
	    }  
	}  


