package com.bilgeadam.repository;

import com.bilgeadam.entity.Subject;
import com.bilgeadam.utility.MyFactoryRepository;

public class SubjectRepository extends MyFactoryRepository<Subject, Long> {

	public SubjectRepository() {
		super(new Subject());
		// TODO Auto-generated constructor stub
	}

}
