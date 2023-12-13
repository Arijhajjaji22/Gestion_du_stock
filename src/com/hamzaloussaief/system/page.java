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
public class page {


/**
 *
 * @author amir
 */

    
    String code, description, etat, numero, lieu, stock, bmvt, type, nombre, 
            id, reference, affect, zoneservice, enservice, observation;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getBmvt() {
        return bmvt;
    }

    public void setBmvt(String bmvt) {
        this.bmvt = bmvt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAffect() {
        return affect;
    }

    public void setAffect(String affect) {
        this.affect = affect;
    }

    public String getZoneservice() {
        return zoneservice;
    }

    public void setZoneservice(String zoneservice) {
        this.zoneservice = zoneservice;
    }

    public String getEnservice() {
        return enservice;
    }

    public void setEnservice(String enservice) {
        this.enservice = enservice;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public page(String code, String description, String etat, String numero, String lieu, String stock, String bmvt, String type, String nombre, String id, String reference, String affect, String zoneservice, String enservice, String observation) {
        this.code = code;
        this.description = description;
        this.etat = etat;
        this.numero = numero;
        this.lieu = lieu;
        this.stock = stock;
        this.bmvt = bmvt;
        this.type = type;
        this.nombre = nombre;
        this.id = id;
        this.reference = reference;
        this.affect = affect;
        this.zoneservice = zoneservice;
        this.enservice = enservice;
        this.observation = observation;
    }
    
    
    
}
    

