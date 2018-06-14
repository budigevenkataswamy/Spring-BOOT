package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepositary;

	private List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring framework","Spring frame work description"),
			new Topic("Java","java framework","core java description"),
			new Topic("Javascript","javascript","javascript description")));
	
	
	public List<Topic> getAllTopics(){
		List<Topic> topics= new ArrayList<>();
		topicRepositary.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
		return topicRepositary.findById(id);
	}

	public void addTopic(Topic topic) {
		topicRepositary.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		/*for(int i=0;i<topics.size();i++) {
			Topic t=topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		topicRepositary.save(topic);
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t ->t.getId().equals(id));
		topicRepositary.deleteById(id);
	}
	
}
