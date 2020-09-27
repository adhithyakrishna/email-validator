package com.validator.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.validator.shared.ResponseDTO;

@Component
public interface ValidatorService {
	ResponseDTO countValidEmails(List<String> input);
}
