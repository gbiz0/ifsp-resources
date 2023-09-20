/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cLanche.cpp
 * Author: gbiz0
 * 
 * Created on 20 de setembro de 2023, 11:10
 */

#include "cLanche.h"
#include <iostream>
using namespace std;
        
cLanche::cLanche() {
}

cLanche::cLanche(const cLanche& orig) {
}

cLanche::~cLanche() {
}

void cLanche :: lerDados(){
    cout << "* Especificação ** Código ** Preço *" << endl;
    cout << "Cachorro quente --- 100 ---- 1.20" << endl;
    cout << "Bauru simples ----- 101 ---- 1.30" << endl;
    cout << "Bauru com ovo ----- 102 ---- 1.50" << endl;
    cout << "Hambúrger --------- 103 ---- 1.20" << endl;
    cout << "Cheeseburguer ----- 104 ---- 1.30" << endl;
    cout << "Refrigerante ------ 105 ---- 1.00" << endl;
    cout << endl;
    cout << "Informe o código do item que deseja pedir: ";
    cin >> pedido;
    cout << "Informe a quantidade de itens que deseja: ";
    cin >> qtd;
    
    this->imprimir();
}

void cLanche :: imprimir(){
    float preco = 0;
    
    switch(pedido){
        case 100:
            preco = 1.20;
            break;
        case 101:
            preco = 1.30;
            break;
        case 102:
            preco = 1.50;
            break;
        case 103:
            preco = 1.20;
            break;
        case 104:
            preco = 1.30;
            break;
        case 105:
            preco = 1.00;
            break;
        default:
            cout << "O código informado não está registrado!" << endl;
            exit(0);
            break;
    }
    
    float valor = preco * qtd;
    
    cout << endl << "O valor a ser pago será igual a: R$" << valor << endl;
}