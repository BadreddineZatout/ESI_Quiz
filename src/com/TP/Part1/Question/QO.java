package com.TP.Part1.Question;

import java.util.ListIterator;

public class QO extends Questions  {

	public QO() 
	{
		super();
	}
	public QO(String question,Reponse corrigee)
	{
		this.setQuestion(question);
		this.setCorrigee(corrigee);
		this.setType("QO");
	}
	
	public void Evaluation (Reponse R)
	{
		String ch ;
		Boolean B = true;
		ListIterator<String> i = super.getCorrigee().getAnswer().listIterator();
		int j=0;
		super.setRepondu(B);
		while (i.hasNext() && B)
		{
			ch = super.getCorrigee().getAnswer().get(j);
			if (!(R.getAnswer().get(0).contains(ch)))
			{
				B = false;
			}
			j++;
			i.next();
		}
		super.setRepondu_correct(B);
	}
}
