package com.bilgeadam.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SubjectDetail {// select sd from SubjectDetail as sd user.id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String article;

	private LocalDate createdDate;
	private LocalDate updatedDate;
	private boolean enabled;

	@OneToOne()
	private Subject subject;

	@ManyToOne(cascade = CascadeType.ALL)
	User user;

	@OneToMany(mappedBy = "subjectDetail", cascade = CascadeType.ALL)
	List<Question> questions;

	public SubjectDetail() {
		// TODO Auto-generated constructor stub
	}

	public SubjectDetail(User user, String title, String description, String article, LocalDate createdDate,
			LocalDate updatedDate, boolean enabled) {
		super();
		this.user = user;
		this.title = title;
		this.description = description;
		this.article = article;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.enabled = enabled;
	}

	public SubjectDetail(Subject subject, User user, String title, String description, String article,
			LocalDate createdDate, LocalDate updatedDate, boolean enabled) {
		super();
		this.subject = subject;
		this.user = user;
		this.title = title;
		this.description = description;
		this.article = article;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Question> getQuestions() {

		if (questions == null) {

			questions = new ArrayList<>();
		}
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "SubjectDetail [id=" + id + ", title=" + title + ", description=" + description + ", article=" + article
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", enabled=" + enabled
				+ ", subject=" + subject + ", user=" + user + ", questions=" + questions + "]";
	}

}
