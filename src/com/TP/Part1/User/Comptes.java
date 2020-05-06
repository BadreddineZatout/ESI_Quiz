package com.TP.Part1.User;


import java.io.Serializable;
import java.util.Date;


public class Comptes implements Serializable {

	
	//Liste des attributs
	private String Nom ;//Le nom de d’apprenant
	private String prenom ;// Le prénom de d’apprenant
	private Date date_de_Naissance ;//La date de naissance d’apprenant
	private String Adresse ;//L’adresse d’apprenant
	private String Login ;//Nom d’utilisateur de compte d’apprenant
	private String Mot_De_pass ;//Le mot de passe de compte d’apprenant
	
	
	//Liste des Méthodes
	@SuppressWarnings("deprecation")
	public Comptes(String Nom, String prenom, String date, String Adr, String Login, String mot) 
	{
		this.Nom = Nom;
		this.prenom = prenom;
		date_de_Naissance=new Date(date);
		Adresse=Adr;
		this.Login = Login;
		Mot_De_pass = mot;
	}
	
	
	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Date getDate_de_Naissance() {
		return date_de_Naissance;
	}


	public void setDate_de_Naissance(Date date_de_Naissance) {
		this.date_de_Naissance = date_de_Naissance;
	}


	public String getAdresse() {
		return Adresse;
	}


	public void setAdresse(String adresse) {
		Adresse = adresse;
	}


	public String getLogin() {
		return Login;
	}


	public void setLogin(String login) {
		Login = login;
	}


	public String getMot_De_pass() {
		return Mot_De_pass;
	}


	public void setMot_De_pass(String mot_De_pass) {
		Mot_De_pass = mot_De_pass;
	}


	public String GererLogin () {return null;}// Gérer le nom d’utilisateur automatiquement
	public String Gererpassword () {return null;}// Gérer le mot de passe automatiquement
}
