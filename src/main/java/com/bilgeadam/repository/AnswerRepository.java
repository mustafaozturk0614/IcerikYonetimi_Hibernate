package com.bilgeadam.repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.bilgeadam.entity.Answer;
import com.bilgeadam.utility.MyFactoryRepository;

public class AnswerRepository extends MyFactoryRepository<Answer, Long> {

	public AnswerRepository() {
		super(new Answer());
		// TODO Auto-generated constructor stub
	}

	public void fastestResponder() {

		CriteriaQuery<Tuple> criteriaQuery = getCriteriaBuilder().createQuery(Tuple.class);
		Root<Answer> root = criteriaQuery.from(Answer.class);
		Path<Object> x = root.get("createdDate");
		Path<Object> y = root.get("question").get("createdDate");
		Path<Object> z = root.get("user").get("name");

		criteriaQuery.multiselect(x, y, z);

		List<Tuple> list = getEntityManager().createQuery(criteriaQuery).getResultList();

		Long minValue = Long.MAX_VALUE;
		Tuple tuple2 = null;
		long difference = 0;

		for (Tuple tuple : list) {
//			System.out.println(tuple.get(0) + "-" + tuple.get(1) + "-" + tuple.get(2));
			LocalDateTime answerDate = (LocalDateTime) tuple.get(0);
			LocalDateTime questionDate = (LocalDateTime) tuple.get(1);
			difference = questionDate.until(answerDate, ChronoUnit.MINUTES);

			if (difference < minValue) {
				minValue = difference;
				tuple2 = tuple;
			}

		}

		System.out.println(tuple2.get(2) + "-->" + minValue);
	}

}
