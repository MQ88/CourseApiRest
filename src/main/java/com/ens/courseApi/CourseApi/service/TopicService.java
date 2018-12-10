package com.ens.courseApi.CourseApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ens.courseApi.CourseApi.Dao.TopicDao;
import com.ens.courseApi.CourseApi.aspects.TimeTrack;
import com.ens.courseApi.CourseApi.model.Topic;

@Service
public class TopicService {

	@Autowired
	private TopicDao dao;

	@TimeTrack
	public List<Topic> allTopics() {
		List<Topic> t= dao.allTopics();
		return t;
	}

	@TimeTrack
	public Topic TopicById(int id) {
		return dao.TopicById(id);
	}

	@TimeTrack
	public void addTopic(Topic topicToAdd) {
		dao.addTopic(topicToAdd);
	}

	@TimeTrack
	public void updateTopic(Topic topicToUpdate, int id) {
		dao.updateTopic(topicToUpdate, id);
	}

	@TimeTrack
	public void deleteTopic(int id) {
		dao.deleteTopic(id);

	}

}
