/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.giugno2018;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class torrehannoi extends Application {
    
    Stage mainWindow = null;
    Palo p1 = null;
    Palo p2 = null;
    Palo p3 = null;
    Disco disco1 = null;
    Disco disco2 = null;
    Disco disco3 = null;
    Disco disco4 = null;
    Disco discoAppoggio = null;
    MyTextBox txtFrom = null;
    MyTextBox txtTo = null;
    Palo paloPartenza = null;
    Palo paloArrivo = null;
    Alert alert = new Alert(AlertType.WARNING);
    
    BorderPane prepareSceneContent()
    {
        Palo paloPartenza = null;
        Palo paloArrivo = null;
        BorderPane root = new BorderPane();
        MyButton btnClose = new MyButton("Close", true, new ListenerClose());
        VBox vbVerticaleSx = new VBox();
        vbVerticaleSx.setAlignment(Pos.CENTER_LEFT);
        vbVerticaleSx.getChildren().add(btnClose);
        
        HBox hbSuperiore = new HBox();
        hbSuperiore.setAlignment(Pos.CENTER);
        Label lblFrom = new Label("FROM");
        Label lblTo = new Label("TO");
        txtFrom = new MyTextBox("",true);
        txtTo = new MyTextBox("",true);
        MyButton btnClear = new MyButton("Clear", false, new ListenerClear());
        hbSuperiore.getChildren().addAll(lblFrom,txtFrom,lblTo,txtTo,btnClear);
        
        MyButton btnReset = new MyButton("Reset", false, new ListenerReset());
        VBox vbVerticaleDx = new VBox();
        vbVerticaleDx.setAlignment(Pos.CENTER_RIGHT);
        vbVerticaleDx.getChildren().add(btnReset);
        
        HBox hbInferiore = new HBox();
        hbInferiore.setAlignment(Pos.CENTER);
        MyButton btnMove = new MyButton("Move",false, new ListenerMove());
        hbInferiore.getChildren().add(btnMove);
        
        GridPane gpCentrale = new GridPane();
        gpCentrale.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        p1= new Palo("p1");
        p2= new Palo("p2");
        p3= new Palo("p3");
        gpCentrale.add(p1, 0, 0);
        gpCentrale.add(p2, 1, 0);
        gpCentrale.add(p3, 2, 0);
        gpCentrale.setAlignment(Pos.CENTER);
        disco1 = new Disco(1,Color.GREEN);
        disco2 = new Disco(2,Color.BLUE);
        disco3 = new Disco(3,Color.RED);
        disco4 = new Disco(4,Color.YELLOW);
        
        p1.aggiungi(disco1);
        p1.aggiungi(disco2);
        p1.aggiungi(disco3);
        p1.aggiungi(disco4);
        
        p1.addEventHandler(MouseEvent.MOUSE_CLICKED, new ListenerPali());
        p2.addEventHandler(MouseEvent.MOUSE_CLICKED, new ListenerPali());
        p3.addEventHandler(MouseEvent.MOUSE_CLICKED, new ListenerPali());

        root.setTop(hbSuperiore);
        root.setLeft(vbVerticaleSx);
        root.setRight(vbVerticaleDx);
        root.setCenter(gpCentrale);
        root.setBottom(hbInferiore);

        return root;
    }
    
    class ListenerClose implements EventHandler {
        public void handle(Event t) {

        }
    }
    class ListenerClear implements EventHandler {
        public void handle(Event t) {
            txtFrom.setText("");
            txtTo.setText("");
            paloPartenza = null;
            paloArrivo = null;
        }
    }
    class ListenerReset implements EventHandler {
        public void handle(Event t) {
             p1.reset();
            p2.reset();
            p3.reset();
            p1.aggiungi(disco1);
            p1.aggiungi(disco2);
            p1.aggiungi(disco3);
            p1.aggiungi(disco4);
            txtFrom.setText("");
                txtTo.setText("");
                paloPartenza = null;
                paloArrivo = null;
        }
    }
     class ListenerMove implements EventHandler {
        public void handle(Event t) {
            if (txtFrom.getText().equals("") || txtTo.getText().equals(""))
            {
                erroreTextBoxVuote();
            }
            else
            {
                discoAppoggio = paloPartenza.rimuoviUltimo();
                boolean risultato = paloArrivo.aggiungi(discoAppoggio);
                if (risultato == false)
                {
                    paloPartenza.aggiungi(discoAppoggio);
                    alert.setTitle("ATTENZIONE");
                    alert.setHeaderText("ATTENZIONE!!");
                    alert.setContentText("Impossibile appoggiare un disco su uno più piccolo");
                    alert.showAndWait();
                }
                txtFrom.setText("");
                txtTo.setText("");
                paloPartenza = null;
                paloArrivo = null;
            }
        }
        private void erroreTextBoxVuote()
        {
            alert.setTitle("ATTENZIONE");
            alert.setHeaderText("ATTENZIONE!!");
            alert.setContentText("pali di partenza e di arrivo non definiti");
            alert.showAndWait();
        }
    }
    class ListenerPali implements EventHandler {
        
        public void handle(Event t) {
            String sorgente = t.getSource().toString();
            if (txtFrom.getText().equals("") && txtTo.getText().equals(""))
            {
                switch(sorgente)
                {
                    case "p1":
                        if(!p1.isEmpty())
                        {
                            paloPartenza = p1;
                            txtFrom.setText(paloPartenza.getNome());
                        }
                        else
                            errorePaloPartenza();
                        break;
                    case "p2":
                        if(!p2.isEmpty())
                        {
                            paloPartenza = p2;
                            txtFrom.setText(paloPartenza.getNome());
                        }
                        else
                            errorePaloPartenza();
                        break;
                    case "p3":
                        if(!p3.isEmpty())
                        {
                            paloPartenza = p3;
                            txtFrom.setText(paloPartenza.getNome());
                        }
                        else
                            errorePaloPartenza();
                        break;
                }
                
            } 
            else if (!txtFrom.getText().equals("") && txtTo.getText().equals(""))
            {
                switch(sorgente)
                {
                    case "p1":
                        if(!p1.equals(paloPartenza))
                        {
                            paloArrivo = p1;
                            txtTo.setText(paloArrivo.getNome());
                        }
                        else
                            errorePaloArrivo();
                        break;
                    case "p2":
                        if(!p2.equals(paloPartenza))
                        {
                            paloArrivo = p2;
                             txtTo.setText(paloArrivo.getNome());
                        }
                        else
                            errorePaloArrivo();
                        break;
                    case "p3":
                        if(!p3.equals(paloPartenza))
                        {
                            paloArrivo = p3;
                             txtTo.setText(paloArrivo.getNome());
                        }
                        else
                            errorePaloArrivo();
                        break;
                }
            }
            else if(!txtFrom.getText().equals("") && !txtTo.getText().equals(""))
            {
                errorePaliGiaDefiniti();
            }
        }
        private void errorePaloPartenza()
        {
            alert.setTitle("ATTENZIONE");
            alert.setHeaderText("ATTENZIONE!!");
            alert.setContentText("Il palo di partenza non può essere vuoto");
            alert.showAndWait();
        }
        private void errorePaloArrivo()
        {
            alert.setTitle("ATTENZIONE");
            alert.setHeaderText("ATTENZIONE!!");
            alert.setContentText("il palo di partenza e quello di destinazione non possono coincidere");
            alert.showAndWait();
        }
        private void errorePaliGiaDefiniti()
        {
            alert.setTitle("ATTENZIONE");
            alert.setHeaderText("ATTENZIONE!!");
            alert.setContentText("il palo di partenza e quello di destinazione sono già definiti");
            alert.showAndWait();
        }
    }
    
    
   

    
    /**
     * BOTTONI
     */
    class MyButton extends Button {
        MyButton(String label, boolean isDisabled, EventHandler listener) {
            super(label);
            setMinSize(20, 20);
            setDisable(isDisabled);
            addEventHandler(ActionEvent.ACTION, listener);
        }
    }
    /**
     * 
     */
    class MyTextBox extends TextField
    {
        MyTextBox(String label, boolean isDisable)
        {
            super(label);
            this.setDisable(isDisable);
        }
    }
    
    
    
    public void start(Stage primaryStage) {
        Scene scene = new Scene(this.prepareSceneContent(), 800, 500);
        mainWindow = primaryStage;
        primaryStage.setTitle("Torre Hanoi");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
