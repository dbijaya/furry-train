package com.bijay.springbootjpa.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import com.bijay.springbootjpa.topic.Topic;

@Entity
@Table
public class Course {
	
	@Id
	private String id;
	@Column
	private String name;
	@Column
	@BatchSize(size = 100)
	private String description;
	
//	This annotation give FK relationship i.e Many-to-One relationship between the entities.
	@ManyToOne
	private Topic topic;
	
//	for easier object initialization
	public Course() {
		
	}
	
//	its just for convenience and not really required. just creating this to make it easy to create a new Course objects
//	with a given Topic.
	
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	

}
