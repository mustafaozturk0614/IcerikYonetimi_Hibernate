package com.bilgeadam.repository;

import com.bilgeadam.entity.Question;
import com.bilgeadam.utility.MyFactoryRepository;

public class QuestionRepository extends MyFactoryRepository<Question, Long> {

	public QuestionRepository() {
		super(new Question());
		// TODO Auto-generated constructor stub
	}

}
