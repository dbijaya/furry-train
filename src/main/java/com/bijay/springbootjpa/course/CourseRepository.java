package com.bijay.springbootjpa.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	/*
	 * since CrudRepository is an Interface, we can't add method-implementation,
	 * only we can do is declare method signature. so to do the work, we have to
	 * follow a naming convention, hence the JPA do the rest work for us like:
	 * signature: "findByProperty" and give attribute: as Property
	 * Eg:
	 * 	public List<Course> findByName(String name);
	 *  	public List<Course> findByDescription(String description);
	 */
	
	public List<Course> findByTopicId(String topicId);

}
