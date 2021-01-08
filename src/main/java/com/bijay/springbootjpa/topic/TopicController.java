package com.bijay.springbootjpa.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	/*
	 * this is what we call singleton. the relationship between the Class and Object
	 * here is "has-a" relationship (loosely coupled). when we do extends or
	 * implements in Inheritance, it keeps a "is-a" relationship (strongly coupled.)
	 */
	
	@Autowired
	private TopicService topicService;

	/*
	 * this is for "GET" request. the method="GET" is by-default provided and for
	 * value="" as we specified.
	 */
	
	/*
	 * and yeah, if we have to return response ie GET request then, we use method
	 * with return type. but if we just have to do the request method ie POST, PUT,
	 * DELETE etc, we can use void method i.e no return-type.
	 */
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
//	this is for "GET" for a specific instance. we provide unique id with-in URL.
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	/*
	 * for POST request, we have to specify method = RequestMethod.POST, it a static
	 * class values. and also explicitly specify URL in values="" attribute. since,
	 * we are sending values via URI included inside body of HTTP request, we have
	 * to get using RequestBody and pass with an instance.
	 */
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	/*
	 * for PUT request, we have to specify method is PUT and give value with url and
	 * a unique key/id. because we do update in a single instance so we need to
	 * provide this unique value. then in method, we add a PathVariable with
	 * RequestBody to send value got from body of HTTP request.
	 */
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
