package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import com.TP.Part1.User.*;
import com.TP.Part1.Formation.*;

import java.io.*;
import java.util.List;

public class TPController {
	@FXML private TextField user_box;
	@FXML private PasswordField pass_box;
	@FXML private RadioButton Formateur;
	@FXML private RadioButton App;
	@FXML private Stage Form = new Stage();
	@FXML private Label erreur;
	@FXML private Label erreur2;@FXML private Label erreur3;
	@FXML private TextField User_name;
	@FXML private TextField password;
	@FXML private TextField name;
	@FXML private TextField firstname;
	@FXML private Pane CreerPane;
	@FXML private Pane GererQuiz;
	@FXML private Pane CreerQuestion;
	@FXML private Pane CreerNotion;
	@FXML private TextField QuizQ;
	@FXML private TextField QUIZN;
	@FXML private TextField NotionName;
	@FXML private TextField NotionQ;
	@FXML private TextField Qcm;@FXML private TextField QcmA;@FXML private TextField QcmB;@FXML private TextField QcmC;@FXML private TextField QcmD;
	@FXML private TextField Qcu;@FXML private TextField QcuA;@FXML private TextField QcuB;@FXML private TextField QcuC;@FXML private TextField QcuD;
	@FXML private TextField QO;@FXML private TextField QOA;@FXML private TextField QOB;@FXML private TextField QOC;@FXML private TextField QOD;
	@FXML private RadioButton A;@FXML private RadioButton B;@FXML private RadioButton C;@FXML private RadioButton D;
	@FXML private RadioButton a;@FXML private RadioButton b;@FXML private RadioButton c;@FXML private RadioButton d;
	@FXML private RadioButton Oui;@FXML private RadioButton Non;
	@FXML private DatePicker Date_De_Fin;@FXML private DatePicker Date_De_Debut;
	@FXML private TextField QuizName;
	@FXML
	private Label label0, label1, label2;
	@FXML
	private ListView<String> list, list1;
	@FXML
	private ObservableList<String> q_names = FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> n_names = FXCollections.observableArrayList();
	
	private Formateur f;
	static Apprenant A1;
	private List<Apprenant> apprenant;
	private List<Quiz> quiz;
	private Quiz q;
	private File fichier;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	public void Authen()
	{
		if (Formateur.isSelected())
		{
			try {
				label1.setVisible(false);
				label2.setVisible(false);
				in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("./Data/Formateurs.dat"))));
				f = (Formateur)in.readObject();
				if (f.Authentifier(user_box.getText(), pass_box.getText()))
				{
					label0.setVisible(false);
					FXMLLoader loader = new FXMLLoader(getClass().getResource("Formateur.fxml"));
					Parent root = loader.load();
					Scene scene = new Scene(root);
					Form.setScene(scene);
					Form.show();
				}
				else
				{
					label0.setVisible(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (App.isSelected())
		{
			label0.setVisible(false);
			label2.setVisible(false);
			try {
				fichier = new File("./Data/Apprenants.dat");
				if (fichier.length()==0)
				{
					label1.setVisible(true);
				}
				else
				{
					label0.setVisible(false);
					label1.setVisible(false);
					in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichier)));
					apprenant = (List<Apprenant>)in.readObject();
					boolean cond=false;
					 for (Apprenant a : apprenant)
					 {		
						 if(a.Authentifier(user_box.getText(), pass_box.getText()))
						 {
							 Main.A1 = a;
							 cond=true;
							 label0.setVisible(false);
							 FXMLLoader loader = new FXMLLoader(getClass().getResource("Apprenant.fxml"));
							 Parent root = loader.load();
							 Scene scene = new Scene(root);
							 Form.setScene(scene);
							 Form.show();
						 }
					 }
					 if (!cond)
					 {
						 label0.setVisible(true);
					 }
				}
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}else
		{
			label2.setVisible(true);
		}
	}
	
}
