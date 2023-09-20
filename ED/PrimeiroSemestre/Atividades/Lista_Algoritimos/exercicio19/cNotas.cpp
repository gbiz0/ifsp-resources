/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cNotas.cpp
 * Author: gbiz0
 * 
 * Created on 20 de setembro de 2023, 11:51
 */

#include "cNotas.h"
#include <iostream>
using namespace std;
cNotas::cNotas() {
}

cNotas::cNotas(const cNotas& orig) {
}

cNotas::~cNotas() {
}

void cNotas :: lerNotas(){
    cout << "Informe a primeira nota: ";
    cin >> nota1;
    cout << "Informe a segunda nota: ";
    cin >> nota2;
    cout << "Informe a terceira nota: ";
    cin >> nota3;
    cout << endl << "**********" << endl << "1 - Aritmética" << endl << "2 - Ponderada (3, 3, 4)" << endl << "3 - Harmônica" << endl << "**********" << endl;
    cout << "Informe o tipo de média que deseja calcular: ";
    cin >> tipo;
    
    this->calcular();
}

void cNotas :: calcular(){
    float media = 0;
    
    switch(tipo){
        case 1:
            media = (nota1 + nota2 + nota3)/3;
            break;
        case 2:
            media = (nota1 * 0.3) + (nota2 * 0.3) + (nota3 * 0.4);
            break;
        case 3:
            media = 3/((1/nota1) + (1/nota2) + (1/nota3));
            break;
        default:
            cout << "O tipo de média desejado não é compatível!" << endl;
            exit(0);
            break;
    }
    
    cout << "A média final é: " << media << endl;
}