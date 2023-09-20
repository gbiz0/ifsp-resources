/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cTempo.cpp
 * Author: gbiz0
 * 
 * Created on 19 de setembro de 2023, 13:45
 */

#include "cTempo.h"
#include <iostream>
using namespace std;
cTempo::cTempo() {
}

cTempo::cTempo(const cTempo& orig) {
}

cTempo::~cTempo() {
}

void cTempo :: lerDados(){
    cout << "Informe o tempo de duração do evento em segundos: ";
    cin >> segundos;
    
    this ->imprimir();
}

void cTempo :: imprimir(){
    float minutos = segundos/60;
    float horas = minutos/60;
    
    cout << endl;
    cout << "O tempo de duração do evento em segundos é: " << segundos << endl;
    cout << "O tempo de duração do evento em minutos é: " << minutos << endl;
    cout << "O tempo de duração do evento em horas é: " << horas << endl;
}