package com.validator.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.validator.model.InputModel;
import com.validator.model.ResponseModel;
import com.validator.service.ValidatorService;
import com.validator.shared.ResponseDTO;

/*
 * Controller class whose responsibilities involve handling http calls
 * 
 * ResponseDTO - DTO is a data transfer object that carries data across the processes.
 * 
 * ResponseModel - Model that has to be returned through the API. We do not send DTO as a response to follow the separation of concerns property. 
 */

@RestController
public class RequestRestController {

	@Autowired
	ValidatorService userService;

	@PostMapping("/countemails")
	public ResponseModel createUser(@RequestBody InputModel inputValue) throws Exception {
		
		ResponseDTO response = userService.countValidEmails(inputValue.getInput());
		ResponseModel model = new ResponseModel();
		BeanUtils.copyProperties(response, model);

		return model;
	}
}
