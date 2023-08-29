/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cPessoa.cpp
 * Author: gbiz0
 * 
 * Created on 25 de agosto de 2023, 09:07
 */

#include "cPessoa.h"
#include <iostream>
#include <valarray>
using namespace std;

cPessoa::cPessoa() {
}

cPessoa::cPessoa(const cPessoa& orig) {
}

cPessoa::~cPessoa() {
}
void cPessoa :: receberDados(){
    int quant = 0;
    int pesqCPF;
    
    cout << "Escreva a quantidade de pessoas: ";
    cin >> quant;
    
    Pessoa array[quant];
    
    for (int i = 0; i < quant; i++) {
        cout << "Nome: "; 
        cin >> array[i].nome;
        cout << "CPF: "; 
        cin >> array[i].cpf;
        cout << "Altura: ";
        cin >> array[i].altura;
        cout << "Peso: ";
        cin >> array[i].peso;
        cout << "Sexo (M ou F): ";
        cin >> array[i].sexo;
    }
    cout << "Escreva o CPF que deseja encontrar: ";
    cin >> pesqCPF;
    
    this->imprimirLista(array, quant);
    this->ordenarPessoas(array, quant);
    
    //cout << this->imc(array, this ->localizaPessoa(array, pesqCPF, quant));
}

int cPessoa :: localizaPessoa(Pessoa *array, int pesqCPF, int quant){
    int i;
    while (i < quant){
        if (pesqCPF == array[i].cpf){
            return i;
        }
        i++;
    }
}

float cPessoa :: imc(Pessoa *array, int i){
    float imc = array[i].peso / (array[i].altura * array[i].altura);
    return imc;
}

void cPessoa :: ordenarPessoas(Pessoa array[], int quant){
    int i, j, z;
    Pessoa temp;
        for (i= quant-1; i >= 1; i--) {
            for (j= 0; j < i ;j++){
                if (array[j].nome > array[j+1].nome) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
                z++;
            }
        }
    cout << "Repetições: " << z;
}


void cPessoa :: imprimirLista(Pessoa *array, int quant){
    for (int i = 0; i < quant; i++) {
        cout << array[i].nome;
    }

}