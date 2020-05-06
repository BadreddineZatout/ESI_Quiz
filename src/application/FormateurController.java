package application;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.TP.Part1.Formation.*;
import com.TP.Part1.Question.*;
import com.TP.Part1.User.*;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class FormateurController {
	@FXML private Label erreur;@FXML private Label erreur4;@FXML private Label erreur5;
	@FXML private Label erreur2;@FXML private Label erreur3;
	@FXML private TextField User_name;
	@FXML private TextField password;
	@FXML private TextField name;
	@FXML private TextField firstname;
	@FXML private Pane CreerPane;
	@FXML private Pane GererQuiz;
	@FXML private Pane CreerQuestion;
	@FXML private Pane CreerFormation;
	@FXML private TextField QuizQ;
	@FXML private TextField QUIZN;
	@FXML private TextField NotionName;
	@FXML private TextField NotionQ;
	@FXML private TextField FormationName;
	@FXML private TextField FormationDescription;
	@FXML private DatePicker DateFin;@FXML private DatePicker DateDebut;
	@FXML private TextField Qcm;@FXML private TextField QcmA;@FXML private TextField QcmB;@FXML private TextField QcmC;@FXML private TextField QcmD;
	@FXML private TextField Qcu;@FXML private TextField QcuA;@FXML private TextField QcuB;@FXML private TextField QcuC;@FXML private TextField QcuD;
	@FXML private TextField QO;@FXML private TextField QOA;@FXML private TextField QOB;@FXML private TextField QOC;@FXML private TextField QOD;
	@FXML private RadioButton A;@FXML private RadioButton B;@FXML private RadioButton C;@FXML private RadioButton D;
	@FXML private RadioButton a;@FXML private RadioButton b;@FXML private RadioButton c;@FXML private RadioButton d;
	@FXML private RadioButton Oui;@FXML private RadioButton Non;
	@FXML private DatePicker Date_De_Fin;@FXML private DatePicker Date_De_Debut;
	@FXML private TextField QuizName;
	
	private List<Apprenant> apprenant;
	private Quiz quiz;
	private File fichier;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	
	public void CreerC()
	{
		CreerPane.setVisible(true);
		GererQuiz.setVisible(false);
		CreerQuestion.setVisible(false);
		CreerFormation.setVisible(false);
	}
	public void CreerF()
	{
		CreerPane.setVisible(false);
		GererQuiz.setVisible(false);
		CreerQuestion.setVisible(false);
		CreerFormation.setVisible(true);
	}
	
	public void Sauvgarder()
	{
		apprenant=new ArrayList<Apprenant>();
		 		 
		 try
		 {			
			 Apprenant a=new Apprenant(new Comptes(name.getText(),firstname.getText(),"17/02/2018","",User_name.getText(),password.getText()));
			 fichier= new File("./Data/Apprenants.dat");
			 boolean c = false;
			 if (fichier.length()!=0) 
			 {
				 in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("./Data/Apprenants.dat"))));			
				 apprenant = (List<Apprenant>)in.readObject();
			 c=true;
			 }			
			 out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("./Data/Apprenants.dat"))));
			 boolean cond=false;
			 int i=0;
			 while(i<apprenant.size())
			 {				
				 if (apprenant.get(i).getInfo().getLogin().compareTo(((a.getInfo().getLogin())))==0)
				 {
					 cond=true;
				 }				 
				 i++;
			 }
			 if (!cond) apprenant.add(a);
			 out.writeObject(apprenant);
			 out.close();
			 if (c) in.close();
		 }
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 } 
	}
	
	public void CreerQuestion()
	{
		CreerQuestion.setVisible(true);
		CreerPane.setVisible(false);
		GererQuiz.setVisible(false);
		CreerFormation.setVisible(false);
	}
	public void GererQ()
	{
		CreerQuestion.setVisible(false);
		CreerPane.setVisible(false);
		CreerFormation.setVisible(false);
		GererQuiz.setVisible(true);
	}
	public void CreerFormation()
	{ 
		boolean cond1=false;
		boolean cond2=false;
		List<Quiz> QUIZS =new ArrayList<Quiz>();
		apprenant=new ArrayList<Apprenant>();	
		try
		{			 
			 fichier= new File("./Data/Quiz.dat");
			 if (fichier.length()!=0) 
			 {
				 in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("./Data/Quiz.dat"))));			
				 QUIZS = (List<Quiz>)in.readObject();
				 cond1=true;
				 in.close();
			 }
			 else
			 {
				cond1=false;
			 }
		}			
		catch (Exception e) {
			e.printStackTrace();
		}
		try 
		{
			fichier = new File("./Data/Apprenants.dat");
			if (fichier.length()==0)
			{
				cond2=false;
			}
			else
			{
				erreur4.setVisible(false);
				in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichier)));
				apprenant = (List<Apprenant>)in.readObject();
				cond2=true;
				in.close();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		if (cond1 && cond2) 
			{
				if (DateDebut.getValue()!=null && DateFin.getValue()!=null && FormationName.getText()!="" && FormationDescription.getText()!="") 
				{if (DateDebut.getValue().compareTo( DateFin.getValue())<0)
					{List<Formation> f =new ArrayList<Formation>();
					Formation formation=new Formation(FormationName.getText() , FormationDescription.getText(), DateDebut.getValue(), DateFin.getValue(), QUIZS, apprenant);
				 	try 
				 	{
				 		fichier = new File("./Data/Formation.dat");
				 		if (fichier.length()!=0) 
						 {
							 in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("./Data/Formation.dat"))));			
							 f = (List<Formation>)in.readObject();
							 cond1=true;
							 in.close();
						 }
						f.add(formation);
				 		out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("./Data/Formation.dat"))));
					 	out.writeObject(f);
					 	out.close();
					 	erreur5.setVisible(false);
				 	} 
				 	catch (Exception e) 
				 	{
				 		e.printStackTrace();
				 	}
				}}
				else erreur5.setVisible(true);
				erreur4.setVisible(false);
			}else 
			{
				erreur4.setVisible(true);
			}
	}
	public void CreerQuiz()
	{
		
		quiz=new Quiz();
		if (QuizName.getText()!="") 
		{
			quiz.setNom(QuizName.getText());
			erreur.setVisible(false);
		}
		else {erreur.setVisible(true);}
		if (Date_De_Debut.getValue()!=null) 
		{
			erreur.setVisible(false);
			quiz.setDate_ouvert(Date_De_Debut.getValue());
		}
		else {erreur.setVisible(true);}
		if (Date_De_Fin.getValue()!=null) 
		{
			erreur.setVisible(false);
			quiz.setDate_exp(Date_De_Fin.getValue());
		}
		else {erreur.setVisible(true);}
		if (Oui.isSelected()) 
		{
			erreur.setVisible(false);
			quiz.setOuvert(Oui.isSelected());
		}
		else if (Non.isSelected()) 
		{
			erreur.setVisible(false);
			quiz.setOuvert(Oui.isSelected());
		}
		else {erreur.setVisible(true);}
		if (!erreur.isVisible())
		{
			try
			 {			
				List<Quiz> QUIZS =new ArrayList<Quiz>(); 
				 fichier= new File("./Data/Quiz.dat");
				 boolean c = false;
				 if (fichier.length()!=0) 
				 {
					 in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("./Data/Quiz.dat"))));			
					 QUIZS = (List<Quiz>)in.readObject();
					 c=true;
				 }			
				 out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("./Data/Quiz.dat"))));
				 boolean cond=false;
				 int i=0;
				 while(i<QUIZS.size())
				 {				
					 if (QUIZS.get(i).getNom().compareTo(((quiz.getNom())))==0)
					 {
						 cond=true;
						 erreur2.setVisible(true);
					 }
					 else
					 {
						 erreur2.setVisible(false);
					 }
					 i++;
				 }
				 if (!cond) QUIZS.add(quiz);
				 out.writeObject(QUIZS);
				 out.close();
				 if (c) in.close();
			 }
			 catch (Exception e) 
			 {
				e.printStackTrace();
			 }
		}
	}
	
	public void AjouterQuestion()
	{
		try
		 {			
			List<Quiz> QUIZS =new ArrayList<Quiz>(); 
			List<Notion> Notion =new ArrayList<Notion>(); 
			List<Questions> Questions=new ArrayList<Questions>(); 
			 QCM qcm0;
			 QCU qcu0;
			 QO qo0;
			 Proposition proposition;
			 Reponse corrigee0,corrigee1 ,corrigee2;
			 List <String> choix=new ArrayList<String>();
			 List <String> corrige=new ArrayList<String>();
			fichier= new File("./Data/Quiz.dat");
			 if (fichier.length()!=0) 
			 {
				 in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("./Data/Quiz.dat"))));			
				 QUIZS = (List<Quiz>)in.readObject();				 
				
				 boolean cond=false;
				 int i=0;
				 while(i<QUIZS.size())
				 {				
					 System.out.println(QuizQ.getText());
					 if (QUIZS.get(i).getNom().compareTo(((QuizQ.getText())))==0)
					 {
						 
						 erreur3.setVisible(false);
						 Notion=QUIZS.get(i).getNotions();
						 for (Notion n :Notion)
						 {
							 if( n.getNom().compareTo(NotionQ.getText())==0)
							 {
								 if (Qcm.getText().compareTo("")!=0 && QcmB.getText().compareTo("")!=0 && QcmA.getText().compareTo("")!=0 && QcmC.getText().compareTo("")!=0 && QcmD.getText().compareTo("")!=0 )
								 {
									 if (A.isSelected()||B.isSelected()||C.isSelected()||D.isSelected())
									 {
										 proposition=new Proposition();
										 corrigee0=new Reponse();
										 choix.clear();
										 corrige.clear();
										 choix.add( QcmA.getText());choix.add( QcmB.getText());choix.add( QcmC.getText());choix.add( QcuD.getText());
										 proposition.setChoix(choix);
										 if (A.isSelected())corrige.add(QcmA.getText());
										 if (B.isSelected())corrige.add(QcmB.getText());
										 if (C.isSelected())corrige.add(QcmC.getText());
										 if (D.isSelected())corrige.add(QcmD.getText());
										 corrigee0.setAnswer(corrige);
										 qcu0=new QCU(Qcu.getText(), proposition, corrigee0);
										Questions.add(qcu0) ;
									 }
								 }
								 if (Qcu.getText().compareTo("")!=0 && QcuB.getText().compareTo("")!=0 && QcuA.getText().compareTo("")!=0 && QcuC.getText().compareTo("")!=0 && QcuD.getText().compareTo("")!=0 )
								 {
									 if (a.isSelected()||b.isSelected()||c.isSelected()||d.isSelected())
									 {
										 proposition=new Proposition();
										 corrigee1=new Reponse();
										 choix.clear();
										 corrige.clear();
										 choix.add( QcuA.getText());choix.add( QcuB.getText());choix.add( QcuC.getText());choix.add( QcuD.getText());
										 proposition.setChoix(choix);
										 if (a.isSelected())corrige.add(QcuA.getText());
										 if (b.isSelected())corrige.add(QcuB.getText());
										 if (c.isSelected())corrige.add(QcuC.getText());
										 if (d.isSelected())corrige.add(QcuD.getText());
										 corrigee1.setAnswer(corrige);
										 qcu0=new QCU(Qcu.getText(), proposition, corrigee1);
										Questions.add(qcu0) ;
									 }
								 }
								 if (QO.getText().compareTo("")!=0 && QOB.getText().compareTo("")!=0 && QOA.getText().compareTo("")!=0 && QOC.getText().compareTo("")!=0 && QOD.getText().compareTo("")!=0 )
								 {
									 corrigee2=new Reponse();
									 corrige.clear();
									 corrige.add(QOA.getText());
									 corrige.add(QOB.getText());
									 corrige.add(QOC.getText());
									 corrige.add(QOD.getText());
									 corrigee2.setAnswer(corrige);
									 qo0=new QO(QO.getText(), corrigee2);
								 }
								 n.setQuestions(Questions);
							 }
						 }
					 }
					 else
					 {
						 erreur3.setVisible(true);
					 }
					 i++;
				 }
				 out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("./Data/Quiz.dat"))));				 
				 out.writeObject(QUIZS);
				 out.close();
				 in.close();
			 }			
			 else {}
			
		 }
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 }
	}
	public void AjouterNotion()
	{
		try
		 {			
			List<Quiz> QUIZS =new ArrayList<Quiz>(); 
			List<Notion> Notion =new ArrayList<Notion>(); 
			 fichier= new File("./Data/Quiz.dat");
			 if (fichier.length()!=0) 
			 {
				 in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("./Data/Quiz.dat"))));			
				 QUIZS = (List<Quiz>)in.readObject();				 
				 boolean cond=false;
				 int i=0;
				 while(i<QUIZS.size())
				 {				
					 System.out.println(QUIZN.getText());
					 if (QUIZS.get(i).getNom().compareTo(((QUIZN.getText())))==0)
					 {
						 
						 erreur3.setVisible(false);
						 Notion=QUIZS.get(i).getNotions();
						 for (Notion n :Notion)
						 {
							 if( n.getNom().compareTo(NotionName.getText())==0)
							 {
								 cond=true;
							 }
						 }
					 }
					 else
					 {
						 erreur3.setVisible(true);
					 }
					 i++;
				 }
				 out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("./Data/Quiz.dat"))));
				 if (!cond) {Notion.add(new Notion(NotionName.getText()));erreur3.setVisible(true);erreur3.setText("terminer");}
				 out.writeObject(QUIZS);
				 out.close();
				 in.close();
			 }			
			 else {}
			
		 }
		 catch (Exception e) 
		 {
			e.printStackTrace();
		 }
	}
}
