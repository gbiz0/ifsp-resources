/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cFila.cpp
 * Author: gbiz0
 * 
 * Created on 17 de novembro de 2023, 07:29
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
            
            default:
                break;
        }
    } while(true);
}

void cFila :: inserir(){
    for (int i=0; i<3; i++) {

        cout << "Digite um valor: ";
        this -> aux = (struct no *) malloc (sizeof(struct no));
 
        int valor;
        cin >> valor; // this -> aux -> valor;
        
        if(this->existe(valor)){
          cout << valor << " Já existe!";
          continue;
        }

        this->aux->valor = valor;
        
        if (this->inicio == NULL) {
            this -> inicio = this -> aux; 
        }else{ 
            fim -> prox = aux;
        }
        this->fim = this-> aux; 
    }

}

void cFila :: listar(){
    no *aux = this->inicio;
    
    while(aux != NULL) {
        cout<< aux->valor;
        if (aux->prox != NULL) {
            cout << " | ";
        }
        else 
            cout << "\n";
        
        aux= aux->prox;
    }

}

void cFila :: remover(){
    this->aux = this ->inicio;
    if (aux == NULL){
        return ;
    }
    this->inicio = this->aux->prox;
    free(this->aux);
    cout<<"Removido com sucesso!";
    
}

void cFila :: pesquisar(){
    
    int valor;
    
    cout << "Informe o valor que deseja pesquisar: ";
    
    cin >> valor;
    
    no *aux = this->inicio;
    
    
    while(aux != NULL){
        if(aux->valor == valor){
            cout << "Valor " << valor << " encontrado!\n\n";
            return;
        }
    }
    cout << "Valor não encontrado!\n\n";
}

bool cFila :: existe(int valor){
        
    no *aux = this->inicio;
    
    
    while(aux != NULL){
        if(aux->valor == valor){
            return true;
        }
    }
    return false;
}
