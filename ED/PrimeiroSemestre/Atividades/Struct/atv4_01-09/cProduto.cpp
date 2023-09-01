/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cProduto.cpp
 * Author: gbiz0
 * 
 * Created on 1 de setembro de 2023, 11:12
 */

#include "cProduto.h"
#include <iostream>
using namespace std;

cProduto::cProduto() {
}

cProduto::cProduto(const cProduto& orig) {
}

cProduto::~cProduto() {
}

void cProduto :: lerProduto(){
    int quant = 0;
    int pesqCod;
    int i;
    
    cout << "Escreva a quantidade de produtos a cadastrar: ";
    cin >> quant;
    
    Produto vet[quant];
    
    for (int i = 0; i < quant; i++) {
        cout << "Nome: "; 
        cin >> vet[i].nome;
        cout << "Código: "; 
        cin >> vet[i].cod;
        cout << "Preço: ";
        cin >> vet[i].preco;
    }
    cout << "Escreva o código do produto que deseja encontrar: ";
    cin >> pesqCod;
    
    this ->imprimirProduto(vet, pesqCod, quant);
}

void cProduto :: imprimirProduto(Produto *vet, int pesqCod, int quant){
    int i;
    for (i=0; i < quant; i++){
        if (pesqCod == vet[i].cod) {
            cout << "----------------Produto-------------------------" << endl;
            cout << "Nome: " << vet[i].nome << endl;
            cout << "Código: " <<  vet[i].cod << endl;
            cout << "Preço: " << vet[i].preco << endl;
        }
    }
}