package com.TP.Part1.Formation ;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Date;
import java.util.List;

import com.TP.Part1.User.Apprenant;
import com.TP.Part1.User.Comptes;

public class Formation extends Operation implements Comparator<Apprenant>, Serializable
{

	//Liste des attributs
	private String Nom;			// Le titre de formation
	private String Description ;// Donne quelque information sur la formation
	private LocalDate date_de_Debut;// La date de commence la formation
	private LocalDate date_de_Fin;// La date de terminer la formation
	private List<Quiz> quizs;// La liste des quizs à répondre dans la formation
	private List<Apprenant> apprenant ;//La liste des Apprenants dans la formation

	//Liste des Méthodes
	public Formation(){}

	public Formation(String Nom,String Description,LocalDate localDate ,LocalDate localDate2 , List<Quiz> quizs,List<Apprenant> apprenant  )
	{
		this.Nom =Nom ;
		this.Description=Description;
		this.date_de_Debut=localDate;
		this.date_de_Fin=localDate2;
		this.quizs =quizs ;
		this.apprenant=apprenant ;
	}
	
	public String getNom() 
	{
		return Nom;
	}
	
	public void setNom(String nom) 
	{
		Nom = nom;
	}
	
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public LocalDate getDate_de_Debut() {
		return date_de_Debut;
	}

	public void setDate_de_Debut(LocalDate date_de_Debut) {
		this.date_de_Debut = date_de_Debut;
	}

	public LocalDate getDate_de_Fin() {
		return date_de_Fin;
	}

	public void setDate_de_Fin(LocalDate date_de_Fin) {
		this.date_de_Fin = date_de_Fin;
	}

	public List<Quiz> getQuizs() {
		return quizs;
	}

	public void setQuizs(List<Quiz> quizs) {
		this.quizs = quizs;
	}
	
	public List<Apprenant> getApprenant() {
		return apprenant;
	}

	public void setApprenant(List<Apprenant> apprenant) {
		this.apprenant = apprenant;
	}

	public void Consulter (Apprenant A){
		Quiz Q;
		int j=0;
		ListIterator <Quiz> i = A.getQuizs().listIterator();
		while(i.hasNext())
		{
			Q = A.getQuizs().get(j);
			System.out.println("Le taux d'accomplissment de la quiz "+Q.getNom()+" est : "+Q.getAccompli());
			j++;
			i.next();
		}
	}
	
	public void Classement (List<Apprenant>apprenant )
	{
		int index=0,index2=0;
		double moy= 0;
		List <Quiz>  Q= new ArrayList<Quiz>();
		ListIterator <Apprenant> i = apprenant.listIterator();
		while (i.hasNext())
		{
			Q=apprenant.get(index).getQuizs();
			ListIterator <Quiz> j = Q.listIterator();	
			while (j.hasNext())
			{
				moy+=Q.get(index2).getReussit();
				
				index2++;
				j.next();
			}
			moy=moy/index2;
			apprenant.get(index).setReussitMoy(moy);
			moy= 0;
			index++;
			index2=0;
			i.next();
		}		
		apprenant.sort(Comparator.comparing(Apprenant::getReussitMoy));		
	}
	
	public void Creer (Comptes C){
		Apprenant A = new Apprenant(C);
		apprenant.add(A);
		}
	
	
	// Modifier Un compte
	public void Modifier (Comptes compte)
	{/*****a modifie*******/
		 String Login,Mot_de_pass;  
		 int chois=0;
		 System.out.println("pour modifier le nom d'utilisateur tapez 1 ");
		 System.out.println("pour modifier le mot de pass tapez 2 ");
		 System.out.println("pour modifier les deux tapez 3 ");
		 Scanner lire = new Scanner(System.in);
		try 
		{
		 chois=lire.nextInt();
		 lire.nextLine();
		}
		catch (Exception e) 
		{
		}
		 switch (chois) 
		 {
		 	case 1:
		 		System.out.println("Veuillez entrez le nouveau nom d'utilisateur ");
		 		Login = lire.nextLine();
		 		compte.setLogin(Login);	
		 		break;
		 	case 2:
		 		System.out.println("Veuillez entrez l'ancient mot de pass ");
		 		Mot_de_pass = lire.nextLine();
		 		lire.nextLine();
		 		if (Mot_de_pass.equals(compte.getMot_De_pass()))
		 		{
		 			System.out.println("Veuillez entrez le nouveau mot de pass ");
		 			Mot_de_pass = lire.nextLine();
		 			compte.setMot_De_pass(Mot_de_pass);
		 		}
		 		else System.out.println("l'ancient mot de pass est faux ");
		 		break;
		 	case 3:
		 		System.out.println("Veuillez entrez le nouveau nom d'utilisateur ");
		 		Login = lire.nextLine();
		 		compte.setLogin(Login);
		 		lire.nextLine();
		 		System.out.println("Veuillez entrez l'ancient mot de pass ");
		 		Mot_de_pass = lire.nextLine();
		 		if (Mot_de_pass.equals(compte.getMot_De_pass()))
		 		{
		 			System.out.println("Veuillez entrez le nouveau mot de pass ");
		 			Mot_de_pass = lire.nextLine();
		 			compte.setMot_De_pass(Mot_de_pass);
		 		}
		 		else System.out.println("l'ancient mot de pass est faux ");
		 		break;	
		 	default:
		 		break;
		 }
		 lire.close();
	}
	
	
	//Supprimer Un compte
	public void Supprimer (Apprenant apprenant)
	{
		this.apprenant.remove(apprenant);
	}

	
	// Créer un quiz et l’ajouter le dans la liste des quizs
	public void Creer (Quiz Q){
		quizs.add(Q);
	}
	
	
	// Modifier Un quiz
	public void Modifier (Quiz Q){}
	
	
	// Supprimer Un quiz
	public void Supprimer (Quiz Q){
		quizs.remove(Q);
	}

	@Override
	public int compare(Apprenant o1, Apprenant o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
