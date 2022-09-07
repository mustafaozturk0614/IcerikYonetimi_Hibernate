package com.bilgeadam.repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bilgeadam.entity.SubjectDetail;
import com.bilgeadam.utility.MyFactoryRepository;

public class SubjectDetailRepository extends MyFactoryRepository<SubjectDetail, Long> {

	public SubjectDetailRepository() {
		super(new SubjectDetail());
		// TODO Auto-generated constructor stub
	}

	public void mostContents() {
		CriteriaQuery<Object[]> criteriaQuery = getCriteriaBuilder().createQuery(Object[].class);
		Root<SubjectDetail> root = criteriaQuery.from(SubjectDetail.class);
		Expression<Long> p = getCriteriaBuilder().count(root.get("user").get("id"));
		Path<Object> x = root.get("user").get("id");
		Path<Object> y = root.get("user").get("name");
		criteriaQuery.multiselect(p, root.get("user").get("name")).groupBy(x, y).orderBy(getCriteriaBuilder().desc(p));
		TypedQuery<Object[]> typedQuery = getEntityManager().createQuery(criteriaQuery);
		typedQuery.setMaxResults(1);
		Object[] object = typedQuery.getSingleResult();
		System.out.println("En çok içerik üreten kullanýcý ");
		System.out.println(object[1] + "-->" + object[0]);
	}

	public void mostContents2() {
		openSession();
		String hql = "select count(sd.user.id),sd.user.name  "
				+ " from SubjectDetail as sd group by sd.user.id,sd.user.name " + "order by count(sd.user.id) desc ";
		TypedQuery<Object[]> result = getSession().createQuery(hql, Object[].class);
		result.setMaxResults(1);
		Object[] object = result.getSingleResult();
		System.out.println("En çok içerik üreten kullanýcý ");
		System.out.println(object[1] + "-->" + object[0]);

	}

	public void gtOneCreatedSubjectDetail() {
		CriteriaQuery<Object[]> criteriaQuery = getCriteriaBuilder().createQuery(Object[].class);
		Root<SubjectDetail> root = criteriaQuery.from(SubjectDetail.class);
		Expression<Long> p = getCriteriaBuilder().countDistinct(root.get("subject").get("lesson").get("name"));
		Path<Object> x = root.get("user").get("id");
		Path<Object> y = root.get("user").get("name");
		Predicate z = getCriteriaBuilder().gt(p, 1);
		criteriaQuery.multiselect(p, x, y).groupBy(x, y).having(z);

		List<Object[]> list = getEntityManager().createQuery(criteriaQuery).getResultList();

		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}

	}

	public void gtOneCreatedSubjectDetail2() {
		openSession();
		String hql = "select count(distinct(sd.subject.lesson.name)),sd.user.name"
				+ " from SubjectDetail as sd group by sd.user.id,sd.user.name having count(distinct(sd.subject.lesson.name))>1 ";
		TypedQuery<Object[]> result = getSession().createQuery(hql, Object[].class);

		List<Object[]> object = result.getResultList();
		System.out.println("Birden falz içerik üreten editör sayýsý ");
		System.out.println(object.size());

	}

	public void isContain() {
		CriteriaQuery<SubjectDetail> criteriaQuery = getCriteriaBuilder().createQuery(SubjectDetail.class);
		Root<SubjectDetail> root = criteriaQuery.from(SubjectDetail.class);
		Expression<Long> p = getCriteriaBuilder().count(root.get("user").get("id"));

		Expression<String> y = root.get("article");
		Expression<String> x = getCriteriaBuilder().concat("%", getCriteriaBuilder().concat(root.get("title"), "%"));
		criteriaQuery.select(root).where(getCriteriaBuilder().notLike(y, x));
		List<SubjectDetail> list = getEntityManager().createQuery(criteriaQuery).getResultList();

		list.forEach(System.out::println);

	}

}
