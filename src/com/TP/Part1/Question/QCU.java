package com.TP.Part1.Question;

import java.io.Serializable;

public class QCU extends QCM  implements Serializable  {
	public QCU(){}
	public QCU(String question, Proposition proposition,Reponse corrigee)
	{
		super(question, proposition,corrigee);						
		this.setType("QCU");
	}
	
	public void Evaluation (Reponse R)
	{
		boolean B = true;
		String ch = super.getCorrigee().getAnswer().get(0);
		super.setRepondu(B);
		if (!ch.equals(R.getAnswer().get(0))) B = false;
		super.setRepondu_correct(B);
	}
}
