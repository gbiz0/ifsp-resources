/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cTabuada.cpp
 * Author: gbiz0
 * 
 * Created on 15 de setembro de 2023, 09:42
 */

#include "cTabuada.h"
#include <iostream>
using namespace std;
cTabuada::cTabuada() {
}

cTabuada::cTabuada(const cTabuada& orig) {
}

cTabuada::~cTabuada() {
}

void cTabuada :: lerDados(){
    int number;
    cout << "Escreva o número que deseja calcular: ";
    cin >> number;
    calcular(1, number);
}

int cTabuada :: calcular(int i, int number){
    if (i <= 10){
        cout << "\n"<< number << " x " << i << " = " << number * i;
        calcular(i+1, number);
    }
}