/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cMultiplo.cpp
 * Author: gbiz0
 * 
 * Created on 20 de setembro de 2023, 10:39
 */

#include "cMultiplo.h"
#include <iostream>
using namespace std;

cMultiplo::cMultiplo() {
}

cMultiplo::cMultiplo(const cMultiplo& orig) {
}

cMultiplo::~cMultiplo() {
}

void cMultiplo :: lerDados(){
    cout << "Informe o valor de a: ";
    cin >> a;
    cout << "Informe o valor de b: ";
    cin >> b;
    
    this->calculo();
}

void cMultiplo :: calculo(){
    if (a % b == 0 || b % a == 0){
        cout << "São múltiplos";
    } else 
        cout << "NÂO são múltiplos";
}