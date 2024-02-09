/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cDupla.cpp
 * Author: gbiz0
 * 
 * Created on 30 de novembro de 2023, 21:11
 */

#include "cDupla.h"
#include <iostream>
using namespace std;
cDupla::cDupla() {
}

cDupla::cDupla(const cDupla& orig) {
}

cDupla::~cDupla() {
}


void cDupla :: menu(){
    int opc;
    do{
        cout <<"Escreva a opção que deseja: \n";
        cout <<"1- Inserir \n";
        cout <<"2- Remover \n";
        cout <<"3- Pesquisa \n";
        cout <<"4- Listar \n";
        cin >>opc;
        
        switch (opc) {
            case 1:
                this->inserir();
                break;
            
            case 2: 
                this->remover();
                break;
                
            case 3:
                this->pesquisar();
                break;
                
            case 4:
                this->listar();
                break;
            
            default:
                break;
        }
    } while(true);
}

void cDupla :: inserir(){
    this->aux = (struct *no) malloc(sizeof(struct no));
    
    int valor;
    cin >> valor; 
        if (this->inicio == NULL) {
            this -> inicio = this -> aux; 
        }else{ 
            fim -> prox = aux;
        }
        this->fim = this-> aux; 
}

void cDupla :: remover (){
    this->aux == this->prox;
    if(aux == NULL){
        return;
    }
    this->inicio = this->aux.prox;
    
}