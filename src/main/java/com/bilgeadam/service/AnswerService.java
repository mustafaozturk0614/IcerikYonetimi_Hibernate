package com.bilgeadam.service;

import com.bilgeadam.entity.Answer;
import com.bilgeadam.repository.AnswerRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class AnswerService extends MyFactoryService<MyFactoryRepository, Answer, Long> {

	public AnswerService() {
		super(new AnswerRepository());
		// TODO Auto-generated constructor stub
	}

}
