package com.TP.Part1.User;

import java.util.List;

public interface User 
{
	// Confirmer Le nom d’utilisateur et le mot de passe
	
	Boolean Authentifier (String Login, String Password);
	
	
	
	// Afficher un liste d’objets (les quizs, les questions, Les notions)
	
	void Afficher (List<Object> O);
	
	
	
	// Sauvegarder un liste d’objets (les quizs, les questions, Les notions) après une modification
	
	void Sauvegarder (List<Object> O);
}
