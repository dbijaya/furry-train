package com.bijay.springbootjpa.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//a Service (Business Service in Spring) is a singleton.
//When application starts up, Spring creates an instance of the service and it keeps that in its memory.

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	
//	here, Array was immutable DS, so to add new data from POST, we have to have Mutable type.
//	so we added new ArrayList i.e collection-type DS to add new data.
	
	// private List<Topic> topics = new ArrayList<>( Arrays.asList(
	// 		new Topic("Spring", "Spring Framework", "Spring Description"),
	// 		new Topic("Java", "core java", "Core Java Description"),
	// 		new Topic("JavaScript", "JavaScript", "JavaScript Description")
	// 		));
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	/*
	 * here, we have to update in a particular Topic instance, so we loop through
	 * the Topic instances and update that instance data if the request-id and
	 * Topic-instance-id matches.
	 * here, the topics.set(key, value) does the work.
	 */
	public void updateTopic(Topic topic, String id) {
//		for(int i = 0; i < topics.size(); i++) {
//			Topic tp = topics.get(i);
//			if(tp.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		
		/*
		 * since CrudRepository doesnt have update() method the work is done by save()
		 * method. also, we dont have to explicitly provide id, in request object if the
		 * id exists it automatically does update, if not it will do create.
		 * so, as long as the Topic instance has id included the update operation gonna execute.
		 */
		topicRepository.save(topic);
	}
	
	/*
	 * here, we used removeIf() method to DELETE the requested instance from HTTP
	 * request object. the '->' is called lambda function (one-paramerer function)
	 * is used.
	 */
	public void deleteTopic(String id) {
//		topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
	
}
