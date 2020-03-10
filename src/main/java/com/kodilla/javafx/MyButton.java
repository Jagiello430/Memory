package com.kodilla.javafx;

import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MyButton extends Button {
    private List<Tile> tileListEasy = new ArrayList<>();
    private List<Tile> tileListMedium = new ArrayList<>();
    private List<Tile> tileListHard = new ArrayList<>();

    List<Tile> tileListEasy() {
        for (int j = 0; j <= 1; j ++){
            for (int i = 1; i <= 4; i++) {
                tileListEasy.add(new Tile(new ImageView("/" + i + ".png"),i));
            }
        }
        Collections.shuffle(tileListEasy);
        return tileListEasy;
    }

    List<Tile> tileListMedium() {
        for (int i = 1; i <= 12; i++) {
            if (i <= 6) {
                tileListMedium.add(new Tile(new ImageView("/" + i + ".png"),i));
            } else {
                tileListMedium.add(new Tile(new ImageView("/" + (i - 6) + ".png"),i - 6));
            }
        }
        Collections.shuffle(tileListMedium);
        return tileListMedium;
    }
    List<Tile> tileListHard() {
        for (int i = 1; i <= 20; i++) {
            if (i <= 10) {
                tileListHard.add(new Tile(new ImageView("/" + i + ".png"),i));
            } else {
                tileListHard.add(new Tile(new ImageView("/" + (i - 10) + ".png"),i - 10));
            }
        }
        Collections.shuffle(tileListHard);
        return tileListHard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyButton myButton = (MyButton) o;

        if (!Objects.equals(tileListEasy, myButton.tileListEasy))
            return false;
        if (!Objects.equals(tileListMedium, myButton.tileListMedium))
            return false;
        return Objects.equals(tileListHard, myButton.tileListHard);
    }

    @Override
    public int hashCode() {
        int result = tileListEasy != null ? tileListEasy.hashCode() : 0;
        result = 31 * result + (tileListMedium != null ? tileListMedium.hashCode() : 0);
        result = 31 * result + (tileListHard != null ? tileListHard.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MyButton{" +
                "tileListEasy=" + tileListEasy +
                ", tileListMedium=" + tileListMedium +
                ", tileListHard=" + tileListHard +
                '}';
    }
}