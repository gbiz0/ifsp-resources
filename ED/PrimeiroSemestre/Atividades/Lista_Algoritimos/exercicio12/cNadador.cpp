/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cNadador.cpp
 * Author: gbiz0
 * 
 * Created on 20 de setembro de 2023, 10:45
 */

#include "cNadador.h"
#include <iostream>
using namespace std;
cNadador::cNadador() {
}

cNadador::cNadador(const cNadador& orig) {
}

cNadador::~cNadador() {
}

void cNadador :: lerDados(){
    cout << "Informe a idade do nadador: ";
    cin >> idade;
    
    this->calcular();
}

void cNadador :: calcular(){
    if (idade >= 5 && idade <= 7){
        cout << "O nadador está na categoria Infantil A";
    } else if (idade >= 8 && idade <= 10){
        cout << "O nadador está na categoria Infantil B";
    } else if (idade >= 11 && idade <= 13){
        cout << "O nadador está na categoria Juvenil A";
    } else if (idade >= 14 && idade <= 17){
        cout << "O nadador está na categoria Juvenil B";
    } else if (idade >= 18){
        cout << "O nadador está na categoria Adulto";
    } else {
        cout << "O nadador não possui idade compatível para a competição!";
    }
}