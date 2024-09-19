/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao2_gustavo_bizo.dto;

/**
 *
 * @author gbiz0
 */
public class BichoDTO {
    private String nome_bicho, tipo_aposta, banca_aposta;
    private double val_aposta;
    private int id_bicho, id_cont;

    public String getNome_bicho() {
        return nome_bicho;
    }

    public void setNome_bicho(String nome_bicho) {
        this.nome_bicho = nome_bicho;
    }

    public String getTipo_aposta() {
        return tipo_aposta;
    }

    public void setTipo_aposta(String tipo_aposta) {
        this.tipo_aposta = tipo_aposta;
    }

    public String getBanca_aposta() {
        return banca_aposta;
    }

    public void setBanca_aposta(String banca_aposta) {
        this.banca_aposta = banca_aposta;
    }

    public double getVal_aposta() {
        return val_aposta;
    }

    public void setVal_aposta(double val_aposta) {
        this.val_aposta = val_aposta;
    }

    public int getId_bicho() {
        return id_bicho;
    }

    public void setId_bicho(int id_bicho) {
        this.id_bicho = id_bicho;
    }

    public int getId_cont() {
        return id_cont;
    }

    public void setId_cont(int id_cont) {
        this.id_cont = id_cont;
    }

   
   
    
}
