/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cValores.cpp
 * Author: gbiz0
 * 
 * Created on 20 de setembro de 2023, 10:27
 */

#include "cValores.h"
#include <iostream>
using namespace std;
cValores::cValores() {
}

cValores::cValores(const cValores& orig) {
}

cValores::~cValores() {
}

void cValores :: lerDados(){
    cout << "Informe o valor de a: ";
    cin >> a;
    cout << "Informe o valor de b: ";
    cin >> b;
    cout << "Informe o valor de c: ";
    cin >> c;
    
    this ->calculo();
}

void cValores :: calculo(){
    int maior;
    
    if (a > b && a > c){
        maior = a;
    }
    
    if (b > a && b > c){
        maior = b;
    }
    
    if (c > a && c > b){
        maior = c;
    }
    
    cout << endl;
    cout << "O maior número digitado foi: " << maior;
}
