/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cMedia.cpp
 * Author: gbiz0
 * 
 * Created on 20 de setembro de 2023, 10:21
 */

#include "cMedia.h"
#include <iostream>
using namespace std;
cMedia::cMedia() {
}

cMedia::cMedia(const cMedia& orig) {
}

cMedia::~cMedia() {
}

void cMedia :: lerDados(){
        cout << "Informe a nota 1: ";
    cin >> n1;
    cout << "Informe a nota 2: ";
    cin >> n2;
    cout << "Informe a nota 3: ";
    cin >> n3;
    
    this ->calcular();
}

void cMedia :: calcular(){
    float media = (n1+n2+n3)/3;
    
    if (media >= 6) {
        cout << "Aluno APROVADO com média: " << media;
    } else
        cout << "Aluno REPROVADO com média: " << media;
}