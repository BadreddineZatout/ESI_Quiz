package com.TP.Part1.Question;

import java.io.Serializable;
import java.util.ListIterator;



public class QCM extends Questions  implements Serializable
{
	//	Les attributs
	
	private Proposition proposition;
	
	//	Les methodes
	public QCM() {}
	
	public QCM(String question,Proposition proposition,Reponse corrigee) 
	{
		super();
		this.setQuestion(question);
		this.setType("QCM");
		this.proposition = proposition;
		this.setCorrigee(corrigee);
	}
	
	public Proposition getProposition() {
		return proposition;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}
	
	public void Evaluation (Reponse R)
	{
		Boolean B = false;
		Boolean end = false;
		String r1,r2;
		int k=0,l=0;
		ListIterator<String> i = R.getAnswer().listIterator();
		ListIterator<String> j = super.getCorrigee().getAnswer().listIterator();
		super.setRepondu(!B);
		while (i.hasNext() && !end)
		{
			r1 = R.getAnswer().get(k);
			while (j.hasNext() && !B)
			{
				r2 = super.getCorrigee().getAnswer().get(l);
				if (r1.equals(r2))
				{
					B = true;
				}		
				l++;
				j.next();
			}
			if (B) B = false;
			else end = true;
			k++;
			i.next();
		}
		super.setRepondu_correct(!end);
	}

	public void Afficher_prop ()
	{
		for (int i=0 ; i<proposition.getChoix().size();i++)
		{
			System.out.println(proposition.getChoix().get(i));
		}
	}
}
