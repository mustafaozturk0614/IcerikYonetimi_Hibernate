package com.bilgeadam.repository;

import com.bilgeadam.entity.Lesson;
import com.bilgeadam.utility.MyFactoryRepository;

public class LessonRepository extends MyFactoryRepository<Lesson, Long> {

	public LessonRepository() {
		super(new Lesson());
		// TODO Auto-generated constructor stub
	}

}
