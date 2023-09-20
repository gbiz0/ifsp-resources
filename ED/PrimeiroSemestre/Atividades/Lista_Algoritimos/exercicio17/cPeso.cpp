/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cPeso.cpp
 * Author: gbiz0
 * 
 * Created on 20 de setembro de 2023, 11:15
 */

#include "cPeso.h"
#include <iostream>
using namespace std;

cPeso::cPeso() {
}

cPeso::cPeso(const cPeso& orig) {
}

cPeso::~cPeso() {
}

void cPeso::lerDados(){
    cout << "Informe o sexo (M - Masculino / F - Feminino): ";
    cin >> sexo;
    cout << "Informe a altura: ";
    cin >> altura;
    
    this->imprimir();
}

void cPeso::imprimir(){
    float peso_ideal = 0;
    
    char sexo_f = toupper(sexo);
    
    switch(sexo_f){
        case 'M':
            peso_ideal = (72.7 * altura) - 58;
            break;
        case 'F':
            peso_ideal = (62.1 * altura) - 44.7;
            break;
        default:
            cout << "O sexo informado não corresponde!" << endl;
            exit(0);
            break;
    }
    
    cout << endl << "Seu peso ideal é: " << peso_ideal << endl;
}