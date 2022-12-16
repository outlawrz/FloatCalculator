package com.example.calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderroot = new BorderPane();
        Text title = new Text("Calculator");
        borderroot.setTop(title);
        borderroot.setAlignment(title, Pos.CENTER);

        VBox cvbox = new VBox();
        borderroot.setCenter(cvbox);

        HBox thbox = new HBox();
        borderroot.setTop(thbox);

        HBox bhbox = new HBox();


        Label answerlabel = new Label("Ans: ");
        TextField answer = new TextField();
        answer.setEditable(false);
        answer.setPromptText("0");

        Label num1Label = new Label("Number A");
        TextField e1 = new TextField();
        e1.setPromptText("0");



        Label num2Label = new Label("Number B");
        TextField e2 = new TextField();
        e2.setPromptText("0");


        Button plus = new Button("+");

        plus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event){
                try{
                    float x1 = Float.parseFloat(e1.getText());
                    float x2 = Float.parseFloat(e2.getText());
                    answer.setText(String.valueOf(x1+x2));
                }catch(NumberFormatException nfe){
                    System.err.println("Invalid input");
                }
            }
        });

        Button times = new Button("*");
        times.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event){

                try{
                    float x1 = Float.parseFloat(e1.getText());
                    float x2 = Float.parseFloat(e2.getText());
                    answer.setText(String.valueOf(x1*x2));
                }catch(NumberFormatException nfe){
                    System.err.println("Invalid input");
                }
            }
        });

        Button minus = new Button("-");
        minus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event){

                try{
                    float x1 = Float.parseFloat(e1.getText());
                    float x2 = Float.parseFloat(e2.getText());
                    answer.setText(String.valueOf(x1-x2));
                }catch(NumberFormatException nfe){
                    System.err.println("Invalid input");
                };
            }
        });

        Button div = new Button("/");
        div.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event){
                try{
                    float x1 = Float.parseFloat(e1.getText());
                    float x2 = Float.parseFloat(e2.getText());
                    if(x2==0){
                        answer.setText("Division by zero error");
                    }
                    else{
                        answer.setText(String.valueOf(x1/x2));
                    }
                }catch(NumberFormatException nfe){
                    System.err.println("Invalid input");
                }



            }
        });

        bhbox.getChildren().addAll(plus,minus,times,div);
        cvbox.getChildren().addAll(num1Label,e1,num2Label,e2,bhbox);
        thbox.getChildren().addAll(answerlabel,answer);

        Scene scene = new Scene(borderroot,400,400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}