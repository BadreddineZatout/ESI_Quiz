package com.TP.Part1.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.TP.Part1.Formation.Notion;
import com.TP.Part1.Formation.Quiz;
import com.TP.Part1.Question.QCM;
import com.TP.Part1.Question.QCU;
import com.TP.Part1.Question.QO;
import com.TP.Part1.Question.Questions;

public class Apprenant implements User, Serializable
{
	private Comptes info; //Les informations d’apprenant
	private List<Quiz> quizs; // La liste des quizs 
	private double reussitMoy; //Taux de réussite moyen
	
	
	//Liste des Méthode
	public Apprenant(Comptes info) 
	{
		this.info=info;
		quizs = new ArrayList<Quiz>();
	}
	
	public Comptes getInfo() {
		return info;
	}

	public void setInfo(Comptes info) {
		this.info = info;
	}
	
	public List<Quiz> getQuizs() {
		return quizs;
	}

	public void setQuizs(List<Quiz> quizs) {
		this.quizs = quizs;
	}
	
	public double getReussitMoy() {
		return reussitMoy;
	}
	
	public void setReussitMoy(double reussitMoy) {
		this.reussitMoy = reussitMoy;
	}
	
	// soumettre les réponses à évaluation
	public void Evaluation (Quiz Q){
		Notion N;
		QCM qcm;
		QCU qcu;
		QO qo;
		int k=0,l=0;
		ListIterator<Notion> i = Q.getNotions().listIterator();
		while (i.hasNext())
		{
			N = Q.getNotions().get(k);
			ListIterator<Questions> j = N.getQuestions().listIterator();
			while (j.hasNext())
			{
				if (N.getQuestions().get(l).getClass()==QCM.class)
				{
					qcm=(QCM)N.getQuestions().get(l);
					qcm.Evaluation();
				}
				else if (N.getQuestions().get(l).getClass()==QCU.class)
				{
						qcu=(QCU)N.getQuestions().get(l);
						qcu.Evaluation();
				}
				else
				{
					qo=(QO)N.getQuestions().get(l);
						qo.Evaluation();
						
				}
				l++;
				j.next();
			}
			k++;
			i.next();
		}
	}
	
	
	// permettre à l’apprenant de choisir un quiz
	public Quiz Choisir (List<Quiz> quizs, String Q_nom){
		Quiz Q = new Quiz();
		for (Quiz Q1 : quizs)
		{
			if (Q1.getNom().equals(Q_nom)){
				Q = Q1;
				break;
			}
		}
		return Q;
	}
	
	
	//Confirmer Le nom d’utilisateur et le mot de passe
	@Override
	public Boolean Authentifier(String Login, String Password) 
	{
		if (!Login.equals(info.getLogin()))	return false;
		else if (!Password.equals(info.getMot_De_pass())) return false;
		else return true;
	}

	
	//Afficher une liste d’objets les quizs
	@Override
	public void Afficher(List<Object> O) 
	{
		
	}

	
	//Sauvegarder une liste des quizs après une modification
	@Override
	public void Sauvegarder(List<Object> O) 
	{
		
	}
}
