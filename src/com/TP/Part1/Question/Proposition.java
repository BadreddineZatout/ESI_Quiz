package com.TP.Part1.Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Proposition  implements Serializable {

	private List<String> choix;
	
	public Proposition()
	{
		choix = new ArrayList<String>();
	}
	
	public List<String> getChoix() {
		return choix;
	}
	
	public void setChoix(List<String> choix) {
		this.choix = choix;
	}
	
	public void addchoix(String prop)
	{
		this.choix.add(prop);
	}
}
