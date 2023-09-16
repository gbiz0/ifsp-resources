/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cNumero.cpp
 * Author: gbiz0
 * 
 * Created on 15 de setembro de 2023, 23:11
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

void cNumero :: lerNum(){
    int n1, n2;
    
    cout << "Escreva o primeiro número: "<<endl;
    cin >> n1;
    
    cout << "Escreva o segundo número: "<<endl;
    cin >> n2;
    
    if (n1 < n2){
        cout << "O menor número é: " << n1;
    } else
        cout << "O menor número é: " << n2;
}