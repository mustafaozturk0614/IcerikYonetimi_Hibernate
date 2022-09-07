package com.bilgeadam.repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.bilgeadam.entity.Question;
import com.bilgeadam.utility.MyFactoryRepository;

public class QuestionRepository extends MyFactoryRepository<Question, Long> {

	public QuestionRepository() {
		super(new Question());
		// TODO Auto-generated constructor stub
	}

	public void mostAskedlesson() {

		CriteriaQuery<Object[]> criteriaQuery = getCriteriaBuilder().createQuery(Object[].class);
		Root<Question> root = criteriaQuery.from(Question.class);

		Path<Object> x = root.get("subjectDetail").get("subject").get("lesson").get("id");
		Path<Object> y = root.get("subjectDetail").get("subject").get("lesson").get("name");

		Expression<Long> p = getCriteriaBuilder().count(x);

		criteriaQuery.multiselect(p, y).groupBy(x, y).orderBy(getCriteriaBuilder().desc(p));

		List<Object[]> list = getEntityManager().createQuery(criteriaQuery).getResultList();

		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}

	}

}
