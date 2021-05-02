package com.javatures.studyapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javatures.studyapp.model.Qa;


@Service
public class QuestionsAndAnswersService {
	
	private static List<Qa> qaList = new ArrayList<>();
	private static int idCounter = 0;
	
	// replace this with database connection later
	static {
		qaList.add(new Qa(++idCounter, "john@gmail.com", "java", "java", "java"));
		qaList.add(new Qa(++idCounter, "john@gmail.com", "react", "react", "react"));
		qaList.add(new Qa(++idCounter, "mary@gmail.com", "html", "html", "html"));
	}
	
	// find all flash cards by user email
	public List<Qa> findAllByUser(String username) {
		System.out.println("QuestionsAndAnswersService.findAllByUser user_login=" + username);
		List<Qa> userQa = new ArrayList<>();
		for(Qa q : qaList) {
			if (q.getUser_email().equals(username)) {
				userQa.add(q);
			}
		}
		System.out.println("QuestionsAndAnswersService.findAllByUser return " + userQa);
		return userQa;
	}
	
	
	// update a flash card by flash card ID
	public Qa update(int id, Qa qa) {
		
		
		System.out.println("QuestionsAndAnswersService.update user_login=" + qa.getUser_email());
		
		Qa temp = null;
		
		for(Qa q : this.qaList) {
			if (q.getQid() == id) {
				temp = q;
			}
		}
		
		if (temp != null) {
			this.qaList.remove(temp);
			qa.setQid(++idCounter);
			this.qaList.add(qa);
		}
		
		return qa;
	}
	
	
	// delete a flash card by flash card ID
	public Qa deleteById(int qaId) {
		System.out.println("******************************");
		System.out.println("QuestionsAndAnswersService.deleteById >>>" + qaId);
		
		Qa temp = null;
		
		for(Qa q : this.qaList) {
			if (q.getQid() == qaId) {
				temp = q;
			}
		}
		
		if (temp != null) qaList.remove(temp);
		
		return temp;
	}
	
	// find a flash card by flash card ID
	public Qa findById(int id) {
		Qa temp = null;
		
		for(Qa q : this.qaList) {
			if (q.getQid() == id) {
				temp = q;
			}
		}
		return temp;
	}

	
	// insert a flash card into data storage
	public Qa insert(Qa qa) {
		if (qa.getUser_email() != null) {
			qa.setQid(++idCounter);
			this.qaList.add(qa);
		}
		return qa;
	}
	
}
