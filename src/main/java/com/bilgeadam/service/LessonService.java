package com.bilgeadam.service;

import com.bilgeadam.entity.Lesson;
import com.bilgeadam.repository.LessonRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class LessonService extends MyFactoryService<MyFactoryRepository, Lesson, Long> {

	public LessonService() {
		super(new LessonRepository());
		// TODO Auto-generated constructor stub
	}

}
