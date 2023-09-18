/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cNota.cpp
 * Author: gbiz0
 * 
 * Created on 18 de setembro de 2023, 17:06
 */

#include "cNota.h"
#include <iostream>
using namespace std;
cNota::cNota() {
}

cNota::cNota(const cNota& orig) {
}

cNota::~cNota() {
}

void cNota :: media(){
    int n1,n2,n3;
    float media;
    
    cout << "Escreva a primeira nota: ";
    cin >> n1;
    cout << "Escreva a segunda nota: ";
    cin >> n2;
    cout << "Escreva a terceira nota: ";
    cin >> n3;
    
    media = (n1*2) + (n2*3) + (n3*5)/3;
    
    cout << "Sua média é: " << media;
} 