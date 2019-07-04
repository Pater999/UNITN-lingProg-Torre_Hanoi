/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.giugno2018;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Palo extends StackPane {
    VBox vbPalo = null;
    private String nome;
    private int numeroDischi;
    
    public Palo(String Nome)
    {
        nome = Nome;
        vbPalo = new VBox();
        vbPalo.setAlignment(Pos.BOTTOM_CENTER);
        Rectangle rettangolo = new Rectangle(20,300);
        this.setPadding(new Insets(40,0,0,0));
        this.setMaxWidth(200);
        this.setMinWidth(200);
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.getChildren().addAll(rettangolo,vbPalo);
        numeroDischi = 0;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public boolean aggiungi(Disco disco)
    {
        if (isEmpty())
        {
            vbPalo.getChildren().add(disco);
            numeroDischi++;
            return true;
        }
        else
        {
            if (disco.getGrandezza() < getUltimo().getGrandezza() )
            {
                vbPalo.getChildren().add(0,disco);
                numeroDischi++;
                return true;
            }  
            else
            {
                return false;
            }
        }
        
    }
    
    public Disco rimuoviUltimo()
    {
        Disco disc = null;
        disc = getUltimo();
        vbPalo.getChildren().remove(0);
        numeroDischi--;
        return disc;
    }
    
    private Disco getUltimo()
    {
        return (Disco)vbPalo.getChildren().get(0);
    }
    
    public boolean isEmpty()
    {
        if (vbPalo.getChildren().size() <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String toString() { 
        return nome;
    }
    
    public void reset()
    {
        vbPalo.getChildren().removeAll();
    }
}
