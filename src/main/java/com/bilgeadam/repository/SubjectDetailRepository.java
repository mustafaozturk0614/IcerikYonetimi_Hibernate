package com.bilgeadam.repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
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

}
