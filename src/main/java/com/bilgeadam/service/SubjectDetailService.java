package com.bilgeadam.service;

import com.bilgeadam.entity.SubjectDetail;
import com.bilgeadam.repository.SubjectDetailRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class SubjectDetailService extends MyFactoryService<MyFactoryRepository, SubjectDetail, Long> {

	public SubjectDetailService() {
		super(new SubjectDetailRepository());
		// TODO Auto-generated constructor stub
	}

}
