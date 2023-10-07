/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cFila.cpp
 * Author: gbiz0
 * 
 * Created on 6 de outubro de 2023, 09:31
 */

#include "cFila.h"
#include <iostream>

using namespace std;

cFila::cFila() {
}

cFila::cFila(const cFila& orig) {
}

cFila::~cFila() {
}

void cFila :: menu(){
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
            
            default
            break;
        }

    } while();
    
}

void cFila :: inserir(){
    cout << "Digite um valor";
    this -> aux = (struct no *) malloc (sizeof(this->aux));
    cin >> this -> aux -> valor;
    
    if (this->inicio == NULL) {
        this -> inicio = this -> aux; 
    }else{ 
        fim -> prox = aux;
    }
    this->fim = this-> aux; 
}

void cFila :: listar(){
    while(this-> inicio != NULL) {
        cout<< this->inicio->valor;
        if (this->inicio->prox != NULL) {
            cout << " | ";
        }
        else 
            cout << ". /n";
    }

}

void cFila :: remover(){
    
}

void cFila :: pesquisar(){
    
}