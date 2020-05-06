package com.TP.Part1.Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Reponse  implements Serializable {

	private List <String> answer;
	
	public Reponse() 
	{
		answer = new ArrayList<String>();
	}
	
	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answerQCM) {
		this.answer = answerQCM;
	}
	
	public void addanswer(String reponse)
	{
		this.answer.add(reponse);
	}
}
