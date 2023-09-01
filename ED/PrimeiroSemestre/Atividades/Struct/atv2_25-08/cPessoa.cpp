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
    float imc;
    
    cout << "Escreva a quantidade de pessoas: ";
    cin >> quant;
    
    Pessoa vet[quant];
    
    for (int i = 0; i < quant; i++) {
        cout << "Nome: "; 
        cin >> vet[i].nome;
        cout << "CPF: "; 
        cin >> vet[i].cpf;
        cout << "Altura: ";
        cin >> vet[i].altura;
        cout << "Peso: ";
        cin >> vet[i].peso;
        cout << "Sexo (M ou F): ";
        cin >> vet[i].sexo;
    }
    cout << "Escreva o CPF que deseja encontrar: ";
    cin >> pesqCPF;
    
    //this->imprimirLista(quant);
    //this->ordenarPessoas(quant);
    
    imc = this->localizaPessoa(vet, pesqCPF, quant);
    cout <<  "O imc do cpf é: " << imc;
}

int cPessoa :: localizaPessoa(Pessoa *vet, int pesqCPF, int quant){
    int i=0;
    float imc;
    for (i=0; i < quant; i++){
        if (pesqCPF == this->vet[i].cpf){
            imc = this->vet[i].peso / (this->vet[i].altura * this->vet[i].altura);
        }
    }
    return imc;
}


void cPessoa :: ordenarPessoas(Pessoa *vet, int quant){
    int i, j, z;
    Pessoa temp;
        for (i= quant-1; i >= 1; i--) {
            for (j= 0; j < i ;j++){
                if (this->vet[j].cpf > this->vet[j+1].cpf) {
                    temp = this->vet[j];
                    this->vet[j] = this->vet[j+1];
                    this->vet[j+1] = temp;
                }
                z++;
            }
        }
    cout << "Repetições: " << z;
}

void cPessoa :: imprimirLista(Pessoa *vet, int quant){
    for (int i = 0; i < quant; i++) {
        cout << this->vet[i].nome;
    }

}

int PesquisaBinaria (int k[], int chave , int N){
    int inf,sup,meio;
    inf=0;
    sup=N-1;
    while (inf<=sup){
        meio=(inf+sup)/2;
        if (chave==k[meio])
            return meio;
        else if (chave<k[meio])
            sup=meio-1;
        else
            inf=meio+1;
    }
    return -1; /* não encontrado */
}