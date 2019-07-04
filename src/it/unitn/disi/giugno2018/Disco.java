/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.giugno2018;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Disco extends HBox {
    int grandezza;
    
    public Disco(int numeroDisco, Color colore)
    {
        int larghezza = 150 - numeroDisco * 10;
        grandezza = larghezza;
        Rectangle rettangolo = new Rectangle(larghezza, 20);
        rettangolo.setFill(colore);
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(rettangolo);
    }
    
    public int getGrandezza()
    {
        return grandezza;
    }
}
