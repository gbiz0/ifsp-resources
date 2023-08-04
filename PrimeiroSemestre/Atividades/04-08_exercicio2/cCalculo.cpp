/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cCalculo.cpp
 * Author: jardi
 * 
 * Created on 4 de Agosto de 2023, 11:02
 */

#include "cCalculo.h"
#include <iostream>
#include <cmath>
using namespace std;

cCalculo::cCalculo() {
}

cCalculo::cCalculo(const cCalculo& orig) {
}

cCalculo::~cCalculo() {
}

void cCalculo::lerNum(){
    
    cout << "Digite o número referente a A\n" << endl;
    cin >> this -> a;
    cout << "Digite o número referente a B\n" << endl;
    cin >> this -> b;
    cout << "Digite o número referente a C\n" << endl;
    cin >> this -> c;

}

float cCalculo::calcularNum(){
    
    float d=0, rs;
    
    rs = sqrt(pow(this->a+this->b, 2) + pow(this->b+this->c, 2));
    d = rs/2;
    
    return d;
}