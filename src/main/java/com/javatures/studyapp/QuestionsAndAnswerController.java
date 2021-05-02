package com.javatures.studyapp;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javatures.studyapp.model.Qa;
import com.javatures.studyapp.service.QuestionsAndAnswersService;


@RestController
@CrossOrigin(origins="http://localhost:3000")
public class QuestionsAndAnswerController {
	
	@Autowired
	private QuestionsAndAnswersService questionsAndAnswersService;
	
	// get all flash cards by username(email address)
	@GetMapping("/users/{username}/qa")
	public List<Qa> getAllQuestionsAndAnswersByUser(@PathVariable String username) {
		System.out.println("QuestionsAndAnswerController.getAllQuestionsAndAnswersByUser user__login=" + username);
		return this.questionsAndAnswersService.findAllByUser(username);
	}
	
	// get a flash card
	@GetMapping("/users/{username}/qa/{id}")
	public Qa getQa(@PathVariable String username, @PathVariable int id) {
		System.out.println("QuestionsAndAnswerController.getQa username=" + username);
		return this.questionsAndAnswersService.findById(id);
	}
	
	
	// delete a flash card
	@DeleteMapping("/users/{username}/qa/{qaId}")
	public ResponseEntity<Void> deleteQa(@PathVariable String username, @PathVariable  int qaId) {
		Qa qa = this.questionsAndAnswersService.deleteById(qaId);
		if(qa != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	// edit/update a flash card
	@PutMapping("/users/{username}/qa/{id}")
	public ResponseEntity<Qa> updateQa(
			@PathVariable String username, 
			@PathVariable int id,
			@RequestBody Qa qa) {
		
		System.out.println("QuestionsAndAnswerController.updateQa QEmail=" + username);
		System.out.println("QuestionsAndAnswerController.updateQa Qa=" + qa);
	
		Qa q = this.questionsAndAnswersService.update(id, qa);
		
		return new ResponseEntity<Qa>(q, HttpStatus.OK);
	}
	
		// create a flash card
		@PostMapping("/users/{username}/qa")
		public ResponseEntity<Void> createQa(
				@PathVariable String username, 
				@RequestBody Qa qa) {
			
			System.out.println("QuestionsAndAnswerController.createQa user__login=" + username);
			
			Qa createdQa = this.questionsAndAnswersService.insert(qa);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/{id}").buildAndExpand(createdQa.getQid()).toUri();
			
			return ResponseEntity.created(uri).build();
			
		}
	
	
	
	@RequestMapping(path="/hello-world", method=RequestMethod.GET)
	public String helloWorld() {
		return "Hello World";
	}
}
