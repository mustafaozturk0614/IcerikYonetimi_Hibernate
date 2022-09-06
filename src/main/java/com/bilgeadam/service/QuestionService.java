package com.bilgeadam.service;

import com.bilgeadam.entity.Question;
import com.bilgeadam.repository.QuestionRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class QuestionService extends MyFactoryService<MyFactoryRepository, Question, Long> {

	public QuestionService() {
		super(new QuestionRepository());
		// TODO Auto-generated constructor stub
	}

}
