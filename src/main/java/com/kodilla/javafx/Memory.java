package com.kodilla.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Memory extends Application {

    private Image menuBackground = new Image( getClass().getResourceAsStream("/13.png"));
    BackgroundSize backgroundSize = new BackgroundSize(653,393,true,true,true,false);
    BackgroundImage backgroundImage = new BackgroundImage(menuBackground,BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,backgroundSize);
    Background background = new Background(backgroundImage);

    Tile tile = new Tile(new ImageView("/" + 1 + ".png"),1);
    MyButton myButton = new MyButton();
    Button start = new Button("START");
    Button exit = new Button("EXIT");
    Button easy = new Button("EASY");
    Button medium = new Button("MEDIUM");
    Button hard = new Button("HARD");

    private Parent createGameSceneEasy() {
        TilePane root = new TilePane();
        root.setPrefSize(892,444);
        root.setHgap(4);
        root.setVgap(4);

        root.getChildren().addAll(myButton.tileListEasy());
        return root;
    }

    private Parent createGameSceneMedium() {
        TilePane root = new TilePane();
        root.setPrefSize(892,668);
        root.setHgap(4);
        root.setVgap(4);

        Label label = new Label("Score: " + tile.scores());
        root.setAlignment(label, Pos.BASELINE_RIGHT);
        root.getChildren().addAll(myButton.tileListMedium());
        return root;
    }

    private Parent createGameSceneHard() {
        TilePane root = new TilePane();
        root.setPrefSize(1116,892);
        root.setHgap(4);
        root.setVgap(4);

        root.getChildren().addAll(myButton.tileListHard());
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane pane = new StackPane();
        pane.setPrefSize(800,480);
        pane.setBackground(background);

        buttonStart(primaryStage);
        buttonExit(primaryStage);
        buttonEasy(primaryStage);
        buttonMedium(primaryStage);
        buttonHard(primaryStage);

        pane.getChildren().addAll(start,exit);

        primaryStage.setTitle("MEMORY");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    private void buttonStart(Stage primaryStage) {
        start.setTranslateY(-100);
        start.setPrefHeight(50);
        start.setPrefWidth(150);
        start.setOnAction(event -> primaryStage.setScene(new Scene(level())));
    }

    private void buttonExit(Stage primaryStage) {
        exit.setTranslateY(100);
        exit.setPrefHeight(50);
        exit.setPrefWidth(150);
        exit.setOnAction(event -> primaryStage.close());
    }

    private void buttonEasy(Stage primaryStage) {
        easy.setPrefHeight(50);
        easy.setPrefWidth(150);
        easy.setTranslateY(-100);
        easy.setOnAction(event -> primaryStage.setScene(new Scene(createGameSceneEasy())));
    }

    private void buttonHard(Stage primaryStage) {
        hard.setPrefHeight(50);
        hard.setPrefWidth(150);
        hard.setTranslateY(100);
        hard.setOnAction(event -> primaryStage.setScene(new Scene(createGameSceneHard())));
    }

    private void buttonMedium(Stage primaryStage) {
        medium.setPrefHeight(50);
        medium.setPrefWidth(150);
        medium.setOnAction(event -> primaryStage.setScene(new Scene(createGameSceneMedium())));
    }

    private Parent level() {

        StackPane pane = new StackPane();
        pane.setPrefSize(800, 480);
        pane.setBackground(background);

        pane.getChildren().addAll(easy,medium,hard);
        return pane;
    }

    public static void main(String[] args) {
        launch(args);
        Tile tile = new Tile(new ImageView("/" + 1 + ".png"),1);
        System.out.println(tile.getScore());
    }
}
