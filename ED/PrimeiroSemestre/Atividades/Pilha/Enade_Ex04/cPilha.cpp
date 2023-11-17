/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cPilha.cpp
 * Author: gbiz0
 * 
 * Created on 17 de novembro de 2023, 09:57
 */

#include "cPilha.h"

#include <iostream>
using namespace std;

cPilha::cPilha() {
}

cPilha::cPilha(const cPilha& orig) {
}

cPilha::~cPilha() {
}

void cPilha :: menu(){
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
                this->meio();
                break;
                
            case 4:
                this->listar();
                break;
            
            default:
                break;
        }
    } while(true);
}

void cPilha :: inserir(){
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

void cPilha :: remover(){
    this->aux = this ->topo;
    if (aux == NULL){
        return ;
    }
    this->topo = this->aux->ant;
    free(this->aux);
    cout<<"Removido com sucesso!";
    
}

void cPilha :: meio(int meio){
    int cont = 0;
    for (aux = topo; aux !=  NULL; aux =aux->ant){
        cont ++;
    }
    
}

