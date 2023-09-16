/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cCalculo.cpp
 * Author: gbiz0
 * 
 * Created on 16 de setembro de 2023, 08:42
 */

#include "cCalculo.h"
#include <iostream>
#include <math.h>
using namespace std;
cCalculo::cCalculo() {
}

cCalculo::cCalculo(const cCalculo& orig) {
}

cCalculo::~cCalculo() {
}

void cCalculo :: lerDados(){
    double volume, raio;
    double PI = 3.14159265358979323846;
    
    cout << "Digite o raio da esfera: ";
    cin >> raio;
    
    volume = (4.0 / 3.0) * PI * pow(raio, 3);
    
    cout << "O volume é: "<< volume;
}