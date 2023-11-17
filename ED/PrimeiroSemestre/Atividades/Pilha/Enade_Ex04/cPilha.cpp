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

bool cPilha::vazio(struct no *campo) {
    return campo == NULL;
}

void cPilha :: inserir(){
    int x;

    cout << "\nEntre com o numero a inserir: ";
    cin>>x;

    this->aux = (struct no *) malloc(sizeof (aux));
    this->aux->valor = x;
    this->aux->ant = this->topo;
    this->topo = this->aux;

    cout << this->aux << "\n";
    cout << this->topo << "\n";
    cout << this->aux->ant << "\n";
    cout << this->topo << "\n";
    cout << "\nElemento inserido!\n\n";

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
void cPilha::exibirValorMeio() {
    cout << "\n\nO valor do meio da pilha é: " << this->meio()->valor;
}

no* cPilha :: meio(int meio){
        int cont = 0;

    this->aux = this->topo;

    while (!this->vazio(this->aux)) {
        cont++;
        this->aux = this->aux->ant;
    }

    int meio = cont / 2;

    this->aux = this->topo;
    cont = 0;

    while (!this->vazio(this->aux)) {
        if (cont == meio) {
            return this->aux;
        }
        cont++;
        this->aux = this->aux->ant;
    }
    return NULL;
    
}

void cPilha::listar() {

    no *p;
    p = this->topo;
    while (!vazio(p->ant)) {
        cout << "\nITEM" << p->valor;
        p = p->ant;
    }
    cout << "\nITEM" << p->valor << "\n\n";

}


