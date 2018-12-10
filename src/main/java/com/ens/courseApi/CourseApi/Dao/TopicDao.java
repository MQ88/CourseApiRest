package com.ens.courseApi.CourseApi.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.ens.courseApi.CourseApi.Exceptions.UserNotFoundException;
import com.ens.courseApi.CourseApi.model.Topic;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TopicDao {
	private  List<Topic> Alltopic;

    @PostConstruct
    public void postInit()
	{
		Alltopic = new ArrayList<>();
		Alltopic.add(new Topic(1, "spring", "Spring Core and AOP"));
		Alltopic.add(new Topic(2, "springBoot", "Spring Boot and tools"));
		Alltopic.add(new Topic(3, "MicroServices", "MicroServices Architecture"));
	}
	
	public List<Topic> allTopics() {
		return Alltopic;
	}

	public Topic TopicById(int id) {
		// return Alltopic.stream().filter(i -> i.getTopicId()==id).findFirst().get();
		for (Topic t : Alltopic) {
			if (t.getTopicId() == id) {
				return t;
			}
		}
		throw new UserNotFoundException(1404, "No User Found", "Cant Find any user with Id"+id);
	}

	public void addTopic(Topic topicToAdd) {
		Alltopic.add(topicToAdd);
	}

	public void updateTopic(Topic topicToUpdate, int id) {
		for (int i = 0; i < Alltopic.size(); i++) {
			if (Alltopic.get(i).getTopicId() == id) {
				Alltopic.set(i, topicToUpdate);
			}
		}

	}

	public void deleteTopic(int id) {
		for (int i = 0; i < Alltopic.size(); i++) {
			if (Alltopic.get(i).getTopicId() == id) {
				Alltopic.remove(i);
			}
		}

	}

}
