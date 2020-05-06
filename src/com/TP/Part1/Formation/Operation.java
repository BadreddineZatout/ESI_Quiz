package com.TP.Part1.Formation;

import java.io.Serializable;

public abstract class Operation  implements Serializable
{
	
	// Créer un nouvel objet (Formation, Quiz, Notion, Question) et l’ajouter dans la liste des objets
	
	public void Creer () {};
	
	
	// Modifier un objet (Formation, Quiz, Notion, Question)
	
	public void Modifier (Object O){};
			
			
	//Supprimer un objet (Formation, Quiz, Notion,Question)
	
	public void Supprimer (Object O){}
}
