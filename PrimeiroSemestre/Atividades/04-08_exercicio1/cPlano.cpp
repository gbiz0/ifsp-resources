/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cPlano.cpp
 * Author: jardi
 * 
 * Created on 7 de Agosto de 2023, 20:40
 */

#include "cPlano.h"
#include <iostream>
#include <cmath>
using namespace std;

cPlano::cPlano() {
}

cPlano::cPlano(const cPlano& orig) {
}

cPlano::~cPlano() {
}
void cPlano::lerPontos(){
    
    cout << "Digite o ponto X1\n" << endl;
    cin >> this -> x1;
    cout << "Digite o ponto Y1\n" << endl;
    cin >> this -> y1;
    cout << "Digite o ponto X2\n" << endl;
    cin >> this -> x2;
    cout << "Digite o ponto Y2\n" << endl;
    cin >> this -> y2;
}

float cPlano::calcularDE(){
    
    float d=0;
    
    d = sqrt(pow(this->x2-this->x1, 2) + pow(this->y2-this->y1, 2));
    
    return d;
}
