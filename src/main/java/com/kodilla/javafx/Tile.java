package com.kodilla.javafx;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.Objects;

public class Tile extends StackPane {

    Button button = new Button("");
    private int score = 100;
    private int clickCount = 2;
    private static Tile selected;

    public Tile(ImageView imageView,int id) {

        button.setPrefWidth(220);
        button.setPrefHeight(220);
        button.setGraphic(imageView);
        button.setId(String.valueOf(id));


        getChildren().add(button);

        button.setOnAction(event -> {

            if (isOpen() || clickCount == 0)
                return;
            clickCount--;
            if (selected == null) {
                selected = this;
                open(() -> {
                });
                System.out.println(selected);
            } else {
                System.out.println(selected);
                open(() -> {
                    if (!theSameButton(selected)) {
                        selected.close();
                        this.close();
                    }
                    selected = null;
                    clickCount = 2;
                });
            }
        });
        close();
        score--;
    }
    public boolean isOpen(){
        return button.getOpacity() == 0.2;
    }
    public void open(Runnable action){
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5),button);
        ft.setToValue(1);
        ft.setOnFinished(event -> action.run());
        ft.play();
    }
    public void close(){
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), button);
        ft.setToValue(0);
        ft.play();
    }
    public boolean theSameButton(Tile other){
        return button.getId().equals(other.button.getId());
    }
    public int scores(){
        score--;
        return score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        if (getScore() != tile.getScore()) return false;
        if (clickCount != tile.clickCount) return false;
        return Objects.equals(button, tile.button);
    }

    @Override
    public int hashCode() {
        int result = button != null ? button.hashCode() : 0;
        result = 31 * result + getScore();
        result = 31 * result + clickCount;
        return result;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "button=" + button +
                ", score=" + score +
                ", clickCount=" + clickCount +
                '}';
    }
}
