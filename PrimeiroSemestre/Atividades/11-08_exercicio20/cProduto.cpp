/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cProduto.cpp
 * Author: gbiz0
 * 
 * Created on 11 de agosto de 2023, 09:16
 */

#include "cProduto.h"
#include <iostream>
#include <cmath>
using namespace std;

cProduto::cProduto() {
}

cProduto::cProduto(const cProduto& orig) {
}

cProduto::~cProduto() {
}

void cProduto::menu(){
    cout << "Escolha seu código:\n";
    cout << "1001\n";
    cout << "1324\n";
    cout << "6548\n";
    cout << "987\n";
    cout << "7623\n";
}

void cProduto::lerCod(){
    char opcao='c';
    float valor;
    int cod, quant;
    do {
        this->menu();
        cout << "Digite o código do seu produto\n";
        cin >> cod;
        cout << "Digite a quantidade do seu produto\n";
        cin >> quant;
        
        valor += this->calcularCod(cod, quant);
        cout << "Valor atual: " << valor;
        
        cout << "\nDigite 'c' para continuar\n";
        cin >> opcao;
    } while(opcao == 'c');
}


float cProduto::calcularCod(int cod, int quant){
    
    float valor;
   
    switch(cod)
    {
        case 1001:
            valor+= quant * 5.32;
            break;
            
        case 1324:
            valor += quant * 6.45;
            break;
        
        case 6548:
            valor += quant * 2.37;
            break;
            
        case 987:
            valor += quant * 5.32;
            break;
            
        case 7623:
            valor += quant * 6.45;
            break;
            
        default:
            cout << "Código inválido"<<endl;
    }
    return valor;
}



