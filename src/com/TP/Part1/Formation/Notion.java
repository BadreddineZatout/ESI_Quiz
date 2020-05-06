package com.TP.Part1.Formation;

import java.io.Serializable;
import java.util.ArrayList;
import com.TP.Part1.Question.*;
import java.util.List;
import java.util.Scanner;

public class Notion extends Operation  implements Serializable {

	//Listes des attributs
	private String Nom ; //Le titre de Notion
	private int Nb_Question ;// Le nombre des questions dans ce notion
	private List<Questions> questions ;// La liste des questions dans ce notion

	//Listes des Méthodes

	
	
	public Notion(String Nom) 
	{
		this.Nom = Nom;
		questions = new ArrayList<Questions>();
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public int getNb_Question() {
		return Nb_Question;
	}

	public void setNb_Question(int nb_Question) {
		Nb_Question = nb_Question;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
	
	// Creer Un nouvelle question et ajouté dans la liste des question
	public void Creer_QCM() {}
	public void Creer_QCM (String question,Proposition proposition,Reponse corrigee) {
		QCM qcm = new QCM( question, proposition, corrigee);
		questions.add(qcm);
	}
	public void Creer_QCU() {}
	public void Creer_QCU (String question,Proposition proposition,Reponse corrigee) {
		QCU qcu = new QCU( question,proposition, corrigee);
		questions.add(qcu);
	}
	
	public void Creer_QO () {
	}
	public void Creer_QO (String question,Reponse corrigee) {
		QO qo = new QO(question, corrigee);
		questions.add(qo);
	}
	
	public void Modifier (Questions question) 
	{
		int chois=0;
		 System.out.println("pour remplacez par une QCM tapez 1 ");
		 System.out.println("pour remplacez par une QCU tapez 2 ");
		 System.out.println("pour remplacez par une QO tapez 3 ");
		try 
		{
			Scanner lire = new Scanner(System.in);
		 chois=lire.nextInt();
		 lire.nextLine();
		 lire.close();
		}
		catch (Exception e) 
		{
		}
		 switch (chois) 
		 {
		 	case 1:
		 		Creer_QCM();
		 		Supprimer(question);			
		 		break;

		 	case 2:Creer_QCU();
		 		Supprimer(question);
		 		break;

		 	case 3:Creer_QO();
		 		Supprimer(question);
		 		break;
		 	default:
				break;
		 }
		
	}
	//Supprimer Une question

	public void Supprimer (Questions question) {
		questions.remove(question);
	}
	
}
