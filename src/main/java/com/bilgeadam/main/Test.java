package com.bilgeadam.main;

import java.time.LocalDate;

import com.bilgeadam.entity.Answer;
import com.bilgeadam.entity.ERole;
import com.bilgeadam.entity.Lesson;
import com.bilgeadam.entity.Question;
import com.bilgeadam.entity.Subject;
import com.bilgeadam.entity.SubjectDetail;
import com.bilgeadam.entity.User;
import com.bilgeadam.service.LessonService;

public class Test {

	public static void loadDatabase() {
		LessonService lessonService = new LessonService();
		// user oluþturma
		User user1 = new User("Mustafa", "Öztürk", ERole.EDITOR, LocalDate.now(), LocalDate.now(), true);
		User user2 = new User("Tuba", "Öztürk", ERole.EDITOR, LocalDate.now(), LocalDate.now(), true);
		User user3 = new User("Eren", "Erenoðlu", ERole.USER, LocalDate.now(), LocalDate.now(), true);
		User user4 = new User("Aras", "Gürel", ERole.USER, LocalDate.now(), LocalDate.now(), true);
		User user5 = new User("Hasan", "Gürel", ERole.EDITOR, LocalDate.now(), LocalDate.now(), true);
//lesson oluþturma
		Lesson lesson1 = new Lesson("Java", "Java-101", LocalDate.now(), LocalDate.now(), true);
		Lesson lesson2 = new Lesson("React", "React-101", LocalDate.now(), LocalDate.now(), true);
//Subject oluþturma
		Subject subject1 = new Subject(lesson1, "Dongu", LocalDate.now(), LocalDate.now(), true);
		Subject subject2 = new Subject(lesson1, "Database", LocalDate.now(), LocalDate.now(), true);
		Subject subject3 = new Subject(lesson1, "Oop", LocalDate.now(), LocalDate.now(), true);
		Subject subject4 = new Subject(lesson2, "Redux", LocalDate.now(), LocalDate.now(), true);
		Subject subject5 = new Subject(lesson2, "Hook", LocalDate.now(), LocalDate.now(), true);
		// subject-lesson iliþkisi
//		subject1.setLesson(lesson1);
//		subject2.setLesson(lesson1);
//		subject3.setLesson(lesson1);
//		subject4.setLesson(lesson2);
//		subject5.setLesson(lesson2);

		lesson1.getSubjects().add(subject1);
		lesson1.getSubjects().add(subject2);
		lesson1.getSubjects().add(subject3);
		lesson2.getSubjects().add(subject4);
		lesson2.getSubjects().add(subject5);

		SubjectDetail subjectDetail1 = new SubjectDetail(subject1, user1, "javada Dongüler", "For", "For Döngüsü",
				LocalDate.now(), LocalDate.now(), true);
		SubjectDetail subjectDetail2 = new SubjectDetail(subject2, user1, "Postgre Sql", "Join", "Join",
				LocalDate.now(), LocalDate.now(), true);
		SubjectDetail subjectDetail3 = new SubjectDetail(subject3, user2, "Oop", "interface", "interface",
				LocalDate.now(), LocalDate.now(), true);
		SubjectDetail subjectDetail4 = new SubjectDetail(subject4, user5, "React -Redux", "redux", "redux",
				LocalDate.now(), LocalDate.now(), true);
		SubjectDetail subjectDetail5 = new SubjectDetail(subject5, user1, "React-hook", "hook", "hook", LocalDate.now(),
				LocalDate.now(), true);
		// Subject- subject Detail ilþkisi
		subject1.setSubjectDetail(subjectDetail1);
		subject2.setSubjectDetail(subjectDetail2);
		subject3.setSubjectDetail(subjectDetail3);
		subject4.setSubjectDetail(subjectDetail4);
		subject5.setSubjectDetail(subjectDetail5);

//		subjectDetail1.setSubject(subject1);
//		subjectDetail2.setSubject(subject2);
//		subjectDetail3.setSubject(subject3);
//		subjectDetail4.setSubject(subject4);
//		subjectDetail5.setSubject(subject5);

		user1.getSubjectDetails().add(subjectDetail1);
		user1.getSubjectDetails().add(subjectDetail2);
		user1.getSubjectDetails().add(subjectDetail5);
		user2.getSubjectDetails().add(subjectDetail3);
		user5.getSubjectDetails().add(subjectDetail4);

		Question question1 = new Question(user3, subjectDetail1, "soru1", LocalDate.now().minusDays(1), LocalDate.now(),
				true);
		Question question2 = new Question(user4, subjectDetail1, "soru2", LocalDate.now().minusDays(3), LocalDate.now(),
				true);
		Question question3 = new Question(user3, subjectDetail1, "soru3", LocalDate.now().minusDays(1), LocalDate.now(),
				true);
		Question question4 = new Question(user3, subjectDetail3, "soru4", LocalDate.now().minusDays(2), LocalDate.now(),
				true);
		Question question5 = new Question(user4, subjectDetail5, "soru5", LocalDate.now().minusDays(2), LocalDate.now(),
				true);

		// question- subject detail iliþkisi
//		question1.setSubjectDetail(subjectDetail1);
//		question2.setSubjectDetail(subjectDetail1);
//		question3.setSubjectDetail(subjectDetail1);
//		question4.setSubjectDetail(subjectDetail3);
//		question5.setSubjectDetail(subjectDetail5);

		subjectDetail1.getQuestions().add(question1);
		subjectDetail1.getQuestions().add(question2);
		subjectDetail1.getQuestions().add(question3);
		subjectDetail3.getQuestions().add(question4);
		subjectDetail5.getQuestions().add(question5);
// question user iliþkisi
//		question1.setUser(user3);
//		question2.setUser(user4);
//		question3.setUser(user3);
//		question4.setUser(user3);
//		question5.setUser(user4);

		Answer answer1 = new Answer(user1, question1, LocalDate.now(), LocalDate.now(), true);
		Answer answer2 = new Answer(user1, question2, LocalDate.now(), LocalDate.now(), true);
		Answer answer3 = new Answer(user1, question3, LocalDate.now(), LocalDate.now(), true);
		Answer answer4 = new Answer(user3, question4, LocalDate.now(), LocalDate.now(), true);
		Answer answer5 = new Answer(user5, question5, LocalDate.now(), LocalDate.now(), true);

		// question answer ilþkisi
//		answer1.setUser(user1);
//		answer2.setUser(user1);
//		answer3.setUser(user1);
//		answer4.setUser(user3);
//		answer5.setUser(user5);

		question1.setAnswer(answer1);
		question2.setAnswer(answer2);
		question3.setAnswer(answer3);
		question4.setAnswer(answer4);
		question5.setAnswer(answer5);

		lessonService.save(lesson1);
		lessonService.save(lesson2);

	}

	public static void main(String[] args) {
		loadDatabase();
//		SubjectDetailRepository subjectDetailRepository = new SubjectDetailRepository();
//
//		subjectDetailRepository.mostContents2();

	}

}
