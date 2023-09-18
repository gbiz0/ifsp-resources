/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cIdadeInverso.cpp
 * Author: gbiz0
 * 
 * Created on 18 de setembro de 2023, 16:55
 */

#include "cIdadeInverso.h"
#include <iostream>
using namespace std;

cIdadeInverso::cIdadeInverso() {
}

cIdadeInverso::cIdadeInverso(const cIdadeInverso& orig) {
}

cIdadeInverso::~cIdadeInverso() {
}

void cIdadeInverso :: lerDados(){
    int dia; 

    cout << "Sua idade em dias: ";
    cin >> dia;
    
    int mes = dia/30;
    int ano = dia/365;
    
    int idadeEmDias = ano + mes + dia;
    cout << "A sua idade em dias é igual a: " << idadeEmDias << endl;
    cout << "A sua idade em meses é igual a: " << mes << endl;
    cout << "A sua idade em anos é igual a: " << ano << endl;
}
