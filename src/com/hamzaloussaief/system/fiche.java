/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaloussaief.system;

/**
 *
 * @author hp
 */
public class fiche {
    int  id ;
    String nom , prenom,ligne,reference,abonné,lieu,date;

    public fiche() {
        
    }

    public fiche(int id, String nom, String prenom, String ligne, String reference, String abonné, String lieu, String date) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.ligne = ligne;
        this.reference = reference;
        this.abonné = abonné;
        this.lieu = lieu;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLigne() {
        return ligne;
    }

    public void setLigne(String ligne) {
        this.ligne = ligne;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAbonné() {
        return abonné;
    }

    public void setAbonné(String abonné) {
        this.abonné = abonné;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}