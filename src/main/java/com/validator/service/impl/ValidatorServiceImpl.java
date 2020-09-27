package com.validator.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.validator.service.ValidatorService;
import com.validator.shared.ResponseDTO;

import java.util.Set;
import java.util.HashSet;

@Service
public class ValidatorServiceImpl implements ValidatorService {

	public ResponseDTO countValidEmails(List<String> emails) {
		Set<String> dataSet = new HashSet<String>();
		int count = 0;
		// Two string buffers are initialized to store the domain and username
		StringBuffer domain = new StringBuffer();
		StringBuffer userName = new StringBuffer();

		for (String email : emails) {

			// The stringbuffers are cleared after each iteration
			domain.setLength(0);
			userName.setLength(0);
			int end = email.length() - 1;

			/*
			 * The string is scanned from the end until the @ symbol is met. The value in
			 */

			while (end > 0) {
				char currentChar = email.charAt(end);
				if (currentChar == '@') {
					domain.append(currentChar);
					break;
				}
				domain.append(currentChar);
				end--;
			}

			// the end variable would be the end index scanning from the start
			int start = 0;

			while (start < end) {
				char currentChar = email.charAt(start);
				if (currentChar != '.') {
					if (currentChar == '+')
						break;
					userName.append(currentChar);
				}
				start++;
			}
			String validEmail = userName.append(domain.reverse()).toString();
			if (!dataSet.contains(validEmail) && validEmail.length() > 0) {
				dataSet.add(validEmail);
				count += 1;
			}
		}
		
		ResponseDTO returnValue = new ResponseDTO();
		returnValue.setCount(count);
		return returnValue;
	}
}
