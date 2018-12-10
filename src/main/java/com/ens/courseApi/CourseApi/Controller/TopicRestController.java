package com.ens.courseApi.CourseApi.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ens.courseApi.CourseApi.model.Topic;
import com.ens.courseApi.CourseApi.service.TopicService;

@RestController
public class TopicRestController {

	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topic")
	public List<Topic> allTopics()
	{
		return topicService.allTopics();
	}
	
	@GetMapping("/topic/{id}")
	public Topic  Topicbyid(@PathVariable int id)
	{
		return topicService.TopicById(id);
	}
	
	@PostMapping("/topic")
	public ResponseEntity<Object> addTopic(@RequestBody Topic newTopicToadd) throws URISyntaxException
	{
		topicService.addTopic(newTopicToadd);
		return ResponseEntity.created(new URI("/topic"+newTopicToadd.getTopicId())).build();
	}	
	
	@DeleteMapping("/topic/{id}")
	public void deleteTopic(@PathVariable(name="id") int id)
	{
		topicService.deleteTopic(id);
	}
	
	@PutMapping("/topic/{id}")
	public void updateTopic(@PathVariable(name="id") int id,@RequestBody Topic topicToUpdate)
	{
		topicService.updateTopic(topicToUpdate, id);
	}
	
}
