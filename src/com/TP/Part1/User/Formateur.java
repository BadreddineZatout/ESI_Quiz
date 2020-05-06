package com.TP.Part1.User;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import com.TP.Part1.Formation.Formation;
import com.TP.Part1.Formation.Operation;

public class Formateur extends Operation implements User, Serializable
{
		//////------------Liste des Attributs------------////
	private List<Formation> formation ;// formation La formation créée par le formateur
	private Comptes compte ;// compte Les informations des apprenants
	
	
	
	/////---------------Liste des Méthodes-------------///
//Le constructeur vide
	public Formateur(String Nom, String prenom, String date, String Adr, String Login, String mot)
	{
		formation = new ArrayList<Formation>();
		compte = new Comptes(Nom, prenom, date, Adr, Login, mot);
	}
	
	public List<Formation> getFormation() {
		return formation;
	}

	public void setFormation(List<Formation> formation) 
	{
		this.formation = formation;
	}

	public Comptes getCompte() {
		return compte;
	}

	public void setCompte(Comptes compte) {
		this.compte = compte;
	}

	// Créer une nouvelle Formation
	@Override
	public void Creer() {
		formation.add(new Formation());
	};
	
	
	// Modifier une formation ou un compte ou un quiz
	public void Modifier (Formation F) {}
	
	// Supprimer une formation ou un compte ou un quiz 
	public void Supprimer (Formation F) {
		formation.remove(F);
	}
	
	
	//Confirmer Le nom d’utilisateur et le mot de passe
	@Override
	public Boolean Authentifier(String Login, String Password)
	{
		if (!Login.equals(compte.getLogin()))	return false;
		else if (!Password.equals(compte.getMot_De_pass())) return false;
		else return true;
	}
	
	
	//Afficher une liste des quiz d’une formation
	@Override
	public void Afficher(List<Object> O) 
	{
		int i;
		for (i=0 ; i<O.size(); i++)
		{
			System.out.println(O.get(i));
		}
	}

	
	// Sauvegarder une liste des quiz après une modification
	@Override
	public void Sauvegarder(List<Object> O) 
	{
	
	}

}
