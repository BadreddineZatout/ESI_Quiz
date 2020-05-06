package com.TP.Part1.Formation ;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import com.TP.Part1.Question.QCM;
import com.TP.Part1.Question.Questions;

public class Quiz extends Operation  implements Serializable
{
	//Liste des Attributs
	private String nom;// Le nom de quiz
	private LocalDate date_ouvert ;//La date d’ouverture du quiz
	private LocalDate date_exp ;//La date d’expiration du quiz
	private List<Notion> notions ;//La liste des notions que le quizz couvre
	private Boolean ouvert;// Un booléen qu’indique si le quiz est ouvert ou non
	private Double accompli ;//Taux d’accomplissement
	private Double reussit ;//Taux de réussite
	
	
	//Liste des Méthodes
	
	public Quiz() 
	{
		nom = "";		
		notions = new ArrayList<Notion>();
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public LocalDate getDate_ouvert() {
		return date_ouvert;
	}
	
	public void setDate_ouvert(LocalDate localDate) {
		this.date_ouvert = localDate;
	}
	
	public LocalDate getDate_exp() {
		return date_exp;
	}
	
	public void setDate_exp(LocalDate localDate) {
		this.date_exp = localDate;
	}
	
	public List<Notion> getNotions() {
		return notions;
	}
	
	public void setNotions(List<Notion> notions) {
		this.notions = notions;
	}
	
	public Boolean getOuvert() {
		return ouvert;
	}
	
	public void setOuvert(Boolean ouvert) {
		this.ouvert = ouvert;
	}
	
	public Double getAccompli() {
		return accompli;
	}
	
	public void setAccompli(Double accompli) {
		this.accompli = accompli;
	}
	
	public Double getReussit() {
		return reussit;
	}
	
	public void setReussit(Double reussit) {
		this.reussit = reussit;
	}
	
	public void Afficher () {
		System.out.println(nom);
		ListIterator<Notion> i =notions.listIterator();
		int j=0,m=0;
		while (i.hasNext())
		{
			System.out.println(notions.get(j).getNom());
			ListIterator<Questions> k = notions.get(j).getQuestions().listIterator();
			while (k.hasNext())
			{
				System.out.println(notions.get(j).getQuestions().get(m).getQuestion());
				QCM qcm = new QCM();
				qcm = (QCM) notions.get(j).getQuestions().get(m);
				qcm.Afficher_prop();
				k.next();			
				m++;
			}
			j++;
			i.next();
		}
	}// Afficher un quiz
	
	public void Creer (String NotionName) 
	{
		Notion N = new Notion(NotionName);		
		notions.add(N);
	}//Créer une nouvelle Notion et l’ajouter dans la liste des notions
	
	public void Modifier (Notion N){}// Modifier une Notion
	
	public void Supprimer (Notion N){
		notions.remove(N);
	}// Supprimer une Notion
	
	public Notion Choisir (String n_nom)
	{
		Notion N = new Notion("");
		for (Notion N1 : notions)
		{
			if (N1.getNom().equals(n_nom))
			{
				N=N1;
				break;
			}
		}
		return N;
	}
}
