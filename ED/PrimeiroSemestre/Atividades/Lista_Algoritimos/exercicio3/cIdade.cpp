/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cIdade.cpp
 * Author: gbiz0
 * 
 * Created on 18 de setembro de 2023, 13:22
 */

#include "cIdade.h"
#include <iostream>
using namespace std;

cIdade::cIdade() {
}

cIdade::cIdade(const cIdade& orig) {
}

cIdade::~cIdade() {
}

void cIdade :: lerIdade(){
    int dia; 
    int mes;
    int ano;
    cout << "Sua idade em dias: ";
    cin >> dia;
    
    cout << "Sua idade em meses: ";
    cin >> mes;
    
    cout << "Sua idade em anos: ";
    cin >> ano;
    
    int idadeEmDias = ano * 365 + mes * 30 + dia;
    
    cout << "Sua idade em dias é: " << idadeEmDias;
}