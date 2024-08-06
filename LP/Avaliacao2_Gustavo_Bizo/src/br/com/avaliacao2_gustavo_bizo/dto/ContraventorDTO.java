/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao2_gustavo_bizo.dto;

/**
 *
 * @author gbiz0
 */
public class ContraventorDTO {
    private String nome_cont, cpf_cont, tipo_cont;
    private String login_cont, senha_cont;
    private int id_cont;

    public String getNome_cont() {
        return nome_cont;
    }

    public void setNome_cont(String nome_cont) {
        this.nome_cont = nome_cont;
    }

    public String getCpf_cont() {
        return cpf_cont;
    }

    public void setCpf_cont(String cpf_cont) {
        this.cpf_cont = cpf_cont;
    }

    public String getTipo_cont() {
        return tipo_cont;
    }

    public void setTipo_cont(String tipo_cont) {
        this.tipo_cont = tipo_cont;
    }

    public String getLogin_cont() {
        return login_cont;
    }

    public void setLogin_cont(String login_cont) {
        this.login_cont = login_cont;
    }

    public String getSenha_cont() {
        return senha_cont;
    }

    public void setSenha_cont(String senha_cont) {
        this.senha_cont = senha_cont;
    }

    public int getId_cont() {
        return id_cont;
    }

    public void setId_cont(int id_cont) {
        this.id_cont = id_cont;
    }
    
    
}