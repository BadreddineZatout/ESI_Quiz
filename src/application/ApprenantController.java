package application;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.TP.Part1.Formation.*;
import com.TP.Part1.Question.Questions;
import com.TP.Part1.User.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ApprenantController {
	@FXML
	private AnchorPane pane;
	@FXML
	private ListView<String> list, list1;
	@FXML
	private ListView<String> list2;
	@FXML
	private ObservableList<String> q_names = FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> n_names = FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> Q_names = FXCollections.observableArrayList();
	@FXML private Stage stage = new Stage();
	@FXML private RadioButton R1;@FXML private RadioButton R2;@FXML private RadioButton R3;@FXML private RadioButton R4;
	@FXML private Label label3;
	@FXML private Pane pane_q;
	@FXML private Pane pane_Q;
	private Apprenant a;
	private List<Formation> form;
	private List<Quiz> quiz;
	private Quiz q;
	private File fichier;
	ObjectOutputStream out;
	ObjectInputStream in;
	
	public void Choisir()
	{
		pane_q.setVisible(true);
		pane_Q.setVisible(false);
		list.getItems().clear();
		list.setVisible(true);
		fichier = new File("./Data/Formation.dat");
		if (fichier.length()!=0)
		{
			try {
				in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichier)));
				form = (List<Formation>) in.readObject();
				quiz = form.get(0).getQuizs();
				for(Quiz q : quiz)
				{
					q_names.add(q.getNom());
				}
				list.setItems(q_names);
				list.getSelectionModel().selectedItemProperty().addListener(
						new ChangeListener<String>() {
							public void changed (ObservableValue<? extends String> arg0, String arg1, String arg2)
							{
								a = Main.A1;
								list1.getItems().clear();
								q = a.Choisir(quiz, list.getSelectionModel().getSelectedItem());
								a.getQuizs().add(q);
								for(Notion n : q.getNotions())
								{
									n_names.add(n.getNom());
								}
								list1.setItems(n_names);
								list1.setVisible(true);
							}
						});
				list1.getSelectionModel().selectedItemProperty().addListener(
						new ChangeListener<String>() {
							public void changed (ObservableValue<? extends String> arg0, String arg1, String arg2)
							{
								pane_q.setVisible(false);
								pane_Q.setVisible(true);
									 for(Questions q : (q.Choisir(list1.getSelectionModel().getSelectedItem()).getQuestions()))
										{
											Q_names.add(q.getQuestion());
										}
									 list2.setItems(Q_names);								
							}
						});
				list2.getSelectionModel().selectedItemProperty().addListener(
						new ChangeListener<String>() {
							public void changed (ObservableValue<? extends String> arg0, String arg1, String arg2)
							{
								
							}
						});
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void clean()
	{
		pane.setOnMouseClicked((MouseEvent e)-> {
			list.getItems().clear();
			list1.getItems().clear();
			list.setVisible(false);
			list1.setVisible(false);
        });
	}
}
