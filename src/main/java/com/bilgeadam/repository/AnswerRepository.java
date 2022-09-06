package com.bilgeadam.repository;

import com.bilgeadam.entity.Answer;
import com.bilgeadam.utility.MyFactoryRepository;

public class AnswerRepository extends MyFactoryRepository<Answer, Long> {

	public AnswerRepository() {
		super(new Answer());
		// TODO Auto-generated constructor stub
	}

}
