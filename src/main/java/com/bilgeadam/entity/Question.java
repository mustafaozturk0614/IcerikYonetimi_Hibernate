package com.bilgeadam.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
	private Answer answer;

	@ManyToOne
	private SubjectDetail subjectDetail;

	String question;

	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private boolean enabled;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	User user;

	public Question() {

	}

	public Question(String question, LocalDateTime createdDate, LocalDateTime updatedDate, boolean enabled) {
		super();
		this.question = question;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.enabled = enabled;
	}

	public Question(User user, SubjectDetail subjectDetail, String question, LocalDateTime createdDate,
			LocalDateTime updatedDate, boolean enabled) {
		super();
		this.user = user;
		this.subjectDetail = subjectDetail;
		this.question = question;
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

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public SubjectDetail getSubjectDetail() {
		return subjectDetail;
	}

	public void setSubjectDetail(SubjectDetail subjectDetail) {
		this.subjectDetail = subjectDetail;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", answer=" + answer + ", subjectDetail=" + subjectDetail + ", question="
				+ question + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", enabled=" + enabled
				+ ", user=" + user + "]";
	}

}
