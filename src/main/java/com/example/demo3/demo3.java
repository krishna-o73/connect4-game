package com.example.demo3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;

public class demo3 extends Application
{
    public static void main(String[] args){
        launch(args);
    }

    public Controller controller;

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        GridPane rootNode = loader.load();

        controller = loader.getController();
        controller.createPlayground();
        MenuBar menubar=createmenu();
        Scene scene = new Scene(rootNode);

        Pane menuPane = (Pane) rootNode.getChildren().get(0);
        menuPane.getChildren().addAll(menubar);
        menubar.prefWidthProperty().bind(stage.widthProperty());



        stage.setScene(scene);
        stage.setTitle("Connect4 game");
        stage.setResizable(false);
        stage.show();
    }
    private MenuBar createmenu() {

        Menu menufile =new Menu("File");
        MenuItem item1=new MenuItem("New Game");
        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                resetgame();
            }
        });

        SeparatorMenuItem item0=new SeparatorMenuItem();
        SeparatorMenuItem item5=new SeparatorMenuItem();

        MenuItem item2=new MenuItem("Quit");
        item2.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        MenuItem item4=new MenuItem("Reset Game");
        menufile.getItems().addAll(item1,item5,item4,item0,item2);

        Menu menuhelp=new Menu("Help");
        MenuItem item3=new MenuItem("About Game");
        SeparatorMenuItem item7=new SeparatorMenuItem();
        MenuItem item6=new MenuItem("About Developer");
        item3.setOnAction(actionEvent -> getabout());
        item6.setOnAction(actionEvent -> getaboutme());
        menuhelp.getItems().addAll(item3,item7,item6);

        MenuBar menubar = new MenuBar();
        menubar.getMenus().addAll(menufile,menuhelp);
        return menubar;
    }

    private void resetgame() {

    }

    private void getaboutme() {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Developer");
        alert.setHeaderText("Sai krishna");
        alert.setContentText("A student sreenidhi institute of science and technology, finished this project in december 2023");
        alert.show();
    }

    private void getabout() {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About this game");
        alert.setHeaderText("Connect4");
        alert.setContentText("Connect Four is a two-player connection game" +
                " in which the players first choose a color and then take turns" +
                "dropping colored discs from the top into a seven-column, six-r" +
                "ow vertically suspended grid. The pieces fall straight down, occ" +
                "upying the next available space within the column. The objective" +
                " of the game is to be the first to form a horizontal, vertical, or" +
                " diagonal line of four of one's own discs. Connect Four is a solve" +
                "d game. The first player can always win by playing the right moves.");
        alert.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}