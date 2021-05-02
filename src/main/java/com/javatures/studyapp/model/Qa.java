package com.javatures.studyapp.model;

public class Qa {
	
	private int Qid;
	private String user_email;
	private String question;
	private String answer;
	private String category;
	
	
	public Qa() {
		
	}


	public Qa(String user_email, String question, String answer, String category) {
		super();
		this.user_email = user_email;
		this.question = question;
		this.answer = answer;
		this.category = category;
	}


	public Qa(int qid, String user_email, String question, String answer, String category) {
		super();
		Qid = qid;
		this.user_email = user_email;
		this.question = question;
		this.answer = answer;
		this.category = category;
	}


	public int getQid() {
		return Qid;
	}


	public void setQid(int qid) {
		Qid = qid;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Qa [Qid=" + Qid + ", user_email=" + user_email + ", question=" + question + ", answer=" + answer
				+ ", category=" + category + "]";
	}
	
	
	
	
	
}
