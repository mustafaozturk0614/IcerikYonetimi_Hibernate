package com.bilgeadam.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private LocalDate createdDate;
	private LocalDate updatedDate;
	private boolean enabled;
	@ManyToOne
	Lesson lesson;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "subject")
	private SubjectDetail subjectDetail;

	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(String name, LocalDate createdDate, LocalDate updatedDate, boolean enabled) {
		super();
		this.name = name;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.enabled = enabled;
	}

	public Subject(Lesson lesson, String name, LocalDate createdDate, LocalDate updatedDate, boolean enabled) {
		super();
		this.lesson = lesson;
		this.name = name;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public SubjectDetail getSubjectDetail() {
		return subjectDetail;
	}

	public void setSubjectDetail(SubjectDetail subjectDetail) {
		this.subjectDetail = subjectDetail;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", enabled=" + enabled + ", lesson=" + lesson + ", subjectDetail=" + subjectDetail + "]";
	}

}
