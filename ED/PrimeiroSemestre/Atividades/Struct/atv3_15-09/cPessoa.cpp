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
#include <string>
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
    int resp = 0;
    int idade;
    int cpf;
    
    cout << "Escreva o número de pessoas: " << endl;
    cin >> quant;
    
    Pessoa vet [quant];
    
    for (int i = 0; i < quant; i++) {
        cout << "Nome: "<< endl;
        cin >> vet[i].nome;
        cout << "CPF: "<< endl;
        cin >> vet[i].cpf;
        cout << "Idade:"<< endl;
        cin >> vet[i].idade;
    };

    cout << "Escreva o CPF que deseja encontrar: "<< endl;
    cin >> pesqCPF;
    
    cout<<"Qual o tipo da pesquisa? [1-Sequencial ; 2-Binaria]"<< endl;
    cin>>resp;
    
    if(resp==1){
        idade = this->procurarDados(vet, pesqCPF, quant); 
        cout << "A idade é: " << idade;
    }
    else if(resp==2){
        this->Ordenador(vet, quant);
        idade = this->procurarDadosB(vet, cpf, quant); 
        cout << "A idade é: " << idade;
    }
    else{
        cout << "Método de pesquisa invalida!";
    }
    
}

//sequencial
int cPessoa :: procurarDados(Pessoa *vet, int pesqCPF,int quant){
    int i=0;
    int idade;
    for (i=0; i < quant; i++){
        if (pesqCPF == vet[i].cpf){
            idade = vet[i].idade;
        }
    }
    return idade;
}

//bubble sort
void cPessoa::Ordenador(Pessoa *vet, int quant){
    int i=0, j=0;
    Pessoa temp;
    
    for (i = quant -1; i>= 1; i--){
        for(j = 0; j < i; j++){
            if(vet[j].cpf>vet[j+1].cpf){
                temp = vet[j];
                vet[j] = vet[j+1];
                vet[j+1] = temp;
            }
        }
    }
}

//binaria
int cPessoa::procurarDadosB(Pessoa *vet, int pesqCPF, int quant){ 
    this->Ordenador(vet, quant);
    int inf,sup,meio;
        inf=0;
        sup=quant-1;
        while (inf<=sup){
            meio=(inf+sup)/2;
            if (pesqCPF == vet[meio].cpf)
                return vet[meio].idade;
            else if (pesqCPF < vet[meio].cpf)
                sup=meio-1;
            else
                inf=meio+1;
        }

        return -1; /* não encontrado */
        }