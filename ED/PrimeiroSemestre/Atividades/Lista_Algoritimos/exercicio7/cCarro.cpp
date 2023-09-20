/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cCarro.cpp
 * Author: gbiz0
 * 
 * Created on 19 de setembro de 2023, 14:00
 */

#include "cCarro.h"
#include <iostream>
using namespace std;
cCarro::cCarro() {
}

cCarro::cCarro(const cCarro& orig) {
}

cCarro::~cCarro() {
}

void cCarro :: lerDados(){
    cout << "Informe o custo de fabricação do carro: ";
    cin >> custo_f;
    
    this ->imprimir();
}

void cCarro :: imprimir(){
    float distribuidor = custo_f * 0.28;
    float impostos = custo_f * 0.45;
    float custo_c = custo_f + distribuidor + impostos;
    
    cout << endl;
    cout << "O custo do consumidor será igual a: " << custo_c << endl;
}