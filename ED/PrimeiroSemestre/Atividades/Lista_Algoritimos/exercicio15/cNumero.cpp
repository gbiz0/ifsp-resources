/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cNumero.cpp
 * Author: gbiz0
 * 
 * Created on 20 de setembro de 2023, 11:02
 */

#include "cNumero.h"
#include <iostream>
using namespace std;

cNumero::cNumero() {
}

cNumero::cNumero(const cNumero& orig) {
}

cNumero::~cNumero() {
}
void cNumero :: lerDados(){
    cout << "Escreva um número";
    cin >> numero;
    
    this->calcular();
}

void cNumero :: calcular(){
    if (numero % 2 == 0){
        cout << "O número " << numero << " é par!" << endl;
    } else {
        cout << "O número " << numero << " é ímpar!" << endl;
    }
    
    if (numero >= 0){
        cout << "O número " << numero << " é positivo!" << endl;
    } else {
        cout << "O número " << numero << " é negativo!" << endl;
    }
}