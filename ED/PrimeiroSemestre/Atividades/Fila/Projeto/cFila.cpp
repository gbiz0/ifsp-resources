/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cFila.cpp
 * Author: gbiz0
 * 
 * Created on 27 de outubro de 2023, 10:24
 */

#include "cFila.h"
#include <iostream>
#include <cstdlib>

using namespace std;

cFila::cFila() {
    this-> aux = NULL;
    this-> fim = NULL;
    this-> inicio = NULL;
}

cFila::cFila(const cFila& orig) {
}

cFila::~cFila() {
}

void cFila::inserir(){
    int x;
    cout<<"Digite o elemento a inserir: ";
    cin>>x;
    this->aux= (struct nodo *) malloc (sizeof(this->aux));
    aux->elem=x;
    aux->prox=NULL;

    if (inicio == 0)
        inicio = aux;
    else{
        fim->prox=aux;
    }
    fim=aux;

     cout<<this->aux->elem<<" Inserido com sucesso!\n\n";
}

void cPilha::removr(void){
	if (!vazio(this->topo)){
	   this->aux=this->topo;
	   this->topo=this->topo->ant;
	   free(this->aux);
	   cout<<"\nRemovido com sucesso!";
	}
}

void cPilha::listar(void){
        nodo *p;
	p = this->topo;
        while (!vazio(p->ant)){
           cout<<"\nITEM"<<p->elem;
           p = p->ant;
        }
        cout<<"\nITEM"<<p->elem<<"\n\n";

	
}

void cPilha::menu(void){
	char op;
	int sair=0;

	topo=NULL;
	for (;sair==0;){
		cout<<"1 -> Insere na fila\n2 -> Remove da fila\n";
		cout<<"3 -> Listar fila\n4 -> Sair da fila\n";
		cout<<"\nDigite uma opção: ";
		cin>>op;
		switch (op)
		{
			case '1': insere(); 
                      break;
		  	case '2': removr(); 
                      break;
			case '3': listar(); 
                      break;
			case '4': sair=1; break;
			default:  {
				  cout<<"Opção invalida! \n";
				  break;
				  }
		}
	}

}
