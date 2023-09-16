/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cMedia.cpp
 * Author: gbiz0
 * 
 * Created on 15 de setembro de 2023, 23:21
 */

#include "cMedia.h"
#include <iostream>
#include <string>
using namespace std;


cMedia::cMedia() {
}

cMedia::cMedia(const cMedia& orig) {
}

cMedia::~cMedia() {
}

void cMedia :: lerNotas(){
    int n1, n2, n3, valor;
    string media;
    
    cout << "Escreva a primeira nota: " << endl;
    cin >> n1;
    
    cout << "Escreva a segunda nota: " << endl;
    cin >> n2;
    
    cout << "Escreva a terceira nota: " << endl;
    cin >> n3;
            
    cout << "Escreva o tipo de média (a/p): " << endl;
    cin >> media;
    
    if (media == "a"){
        valor = n1 + n2 + n3 / 3;
    } else
        valor = (n1*5) + (n2*3) + (n3*2) / 3;
    
    cout << valor;
}