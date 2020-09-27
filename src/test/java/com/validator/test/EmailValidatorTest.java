	package com.validator.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.validator.service.ValidatorService;
import com.validator.service.impl.ValidatorServiceImpl;
import com.validator.shared.ResponseDTO;

public class EmailValidatorTest {
	ValidatorService validService = new ValidatorServiceImpl();

	@Test
	public void countEmail1() {
		String[] data = { "test.email@gmail.com", "test.email+spam@gmail.com", "testemail@gmail.com",
				"test............email@gmail.com", "test............email+iiiiiiiiiiiiiiiii@gmail.com" };
		List<String> input = new ArrayList<String>();
		for (String in : data) {
			input.add(in);
		}
		ResponseDTO result = validService.countValidEmails(input);
		assertEquals(result.getCount(), 1);
	}

	@Test
	public void countEmail2() {
		String[] data = { "test.email@gmail.com", "test.email+spam@list.com", "testemail@gmail.com",
				"test............email@gmail.com", "test............email+iiiiiiiiiiiiiiiii@gmail.com" };
		List<String> input = new ArrayList<String>();
		for (String in : data) {
			input.add(in);
		}
		ResponseDTO result = validService.countValidEmails(input);
		assertEquals(result.getCount(), 2);
	}

	@Test
	public void countEmail3() {
		String[] data = { "test.email+welcome@gmail.com", "test.email+spam@list.com", "testemail@gmail.com",
				"test............email@gmail.com", "test............email+iiiiiiiiiiiiiiiii@gmail.com" };
		List<String> input = new ArrayList<String>();
		for (String in : data) {
			input.add(in);
		}
		ResponseDTO result = validService.countValidEmails(input);
		assertEquals(result.getCount(), 2);
	}

	@Test
	public void countEmail4() {
		String[] data = { "test.email+welcome@gmail.com", "test.email+spam@list.com", "testemail@gmail.com",
				"test............emaidl@gmail.com", "test............email+iiiiiiiiiiiiiiiii@gmail.com" };
		List<String> input = new ArrayList<String>();
		for (String in : data) {
			input.add(in);
		}
		ResponseDTO result = validService.countValidEmails(input);
		assertEquals(result.getCount(), 3);
	}

	@Test
	public void countEmail5() {
		String[] data = { "test+232@gmail.com", "tes.............t+232@gmail.com" };
		List<String> input = new ArrayList<String>();
		for (String in : data) {
			input.add(in);
		}
		ResponseDTO result = validService.countValidEmails(input);
		assertEquals(result.getCount(), 1);
	}
	
	
	@Test
	public void countEmail6() {
		String[] data = { "t.est+232..3@gmail.com", "tes.............t+232@gmail.com" };
		List<String> input = new ArrayList<String>();
		for (String in : data) {
			input.add(in);
		}
		ResponseDTO result = validService.countValidEmails(input);
		assertEquals(result.getCount(), 1);
	}
	
	@Test
	public void countEmail7() {
		String[] data = {  };
		List<String> input = new ArrayList<String>();
		for (String in : data) {
			input.add(in);
		}
		ResponseDTO result = validService.countValidEmails(input);
		assertEquals(result.getCount(), 0);
	}
}
