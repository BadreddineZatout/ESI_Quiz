package com.TP.Part1.Question;

import java.io.Serializable;

public abstract class Questions  implements Serializable {
	
	//	Les Attributs
	
	private String question;
	private String type;
	private boolean repondu;
	private boolean repondu_correct;
	private	Reponse reponse;
	private Reponse corrigee;
	
	//	Les methodes
	
	public Questions(){
		question = "";
		type = "";
		repondu = false;
		repondu_correct=false;
		reponse = new Reponse();
		corrigee = new Reponse();
	}
	
	public boolean isRepondu() {
		return repondu;
	}

	public void setRepondu(boolean repondu) {
		this.repondu = repondu;
	}

	public boolean isRepondu_correct() {
		return repondu_correct;
	}

	public void setRepondu_correct(boolean repondu_correct) {
		this.repondu_correct = repondu_correct;
	}

	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Reponse getReponse() {
		return reponse;
	}

	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}

	public Reponse getCorrigee() {
		return corrigee;
	}

	public void setCorrigee(Reponse corrigee) {
		this.corrigee = corrigee;
	}

	public void Evaluation ()
	{}
	
	}
