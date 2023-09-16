/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cClasse.cpp
 * Author: gbiz0
 * 
 * Created on 16 de setembro de 2023, 00:24
 */

#include "cClasse.h"
#include <iostream>
#include <cmath>
using namespace std;
cClasse::cClasse() {
}

cClasse::cClasse(const cClasse& orig) {
}

cClasse::~cClasse() {
}

void cClasse :: lerNumeros(){
    int a, b, c;
    double valor=0;
    
    cout << "Escreva o valor de A:"<<endl;
    cin >> a;
    
    cout << "Escreva o valor de B:"<<endl;
    cin >> b;
    
    cout << "Escreva o valor de C:"<<endl;
    cin >> c;
    
    valor = pow (b, 2) - 4 * a * c;
    cout << valor;
}