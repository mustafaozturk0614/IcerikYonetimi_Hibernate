package com.bilgeadam.service;

import com.bilgeadam.entity.Subject;
import com.bilgeadam.repository.SubjectRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class SubjectService extends MyFactoryService<MyFactoryRepository, Subject, Long> {

	public SubjectService() {
		super(new SubjectRepository());
		// TODO Auto-generated constructor stub
	}

}
