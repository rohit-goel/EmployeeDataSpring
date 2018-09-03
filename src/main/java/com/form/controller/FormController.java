package com.form.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.form.model.FormMV;
import com.form.model.FormVM;
import com.form.service.FormService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FormController {

	@Autowired
	private FormService formService;

	private static final Logger log = LoggerFactory.getLogger(FormController.class);

	/*
	 * shows the result
	 * 
	 */
	@GetMapping("/getEmpData")
	public ArrayList<FormMV> getData(){
		log.info("get Emp data in Controller");
		return formService.getData();
	}

	/*
	 * saves the data
	 * 
	 */
	@PostMapping("/saveEmpData")
	public FormMV saveData(@RequestBody FormVM formVM) {
		log.info("Save Emp data in Controller");
		return formService.saveData(formVM);
	}
}
