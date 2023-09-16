/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cPessoa.cpp
 * Author: gbiz0
 * 
 * Created on 15 de setembro de 2023, 08:41
 */

#include "cPessoa.h"
#include <iostream>
using namespace std;

cPessoa::cPessoa() {
}

cPessoa::cPessoa(const cPessoa& orig) {
}

cPessoa::~cPessoa() {
}

void cPessoa :: lerDados(){
    int quant = 0;
    int pesqCPF;
    
    cout << "Escreva o número de pessoas: ";
    cin >> quant;
    
    Pessoa vet [quant];
    
    for (int i = 0; i < quant; i++) {
        cout << "Nome: ";
        cin >> vet[i].nome;
        cout << "CPF: ";
        cin >> vet[i].cpf;
    };

    cout << "Escreva o CPF que deseja encontrar: ";
    cin >> pesqCPF;
}

