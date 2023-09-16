/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cContaCorrente.cpp
 * Author: gbiz0
 * 
 * Created on 15 de setembro de 2023, 11:16
 */

#include "cContaCorrente.h"
#include <iostream>;
using namespace std;
cContaCorrente::cContaCorrente() {
}

cContaCorrente::cContaCorrente(const cContaCorrente& orig) {
}

cContaCorrente::~cContaCorrente() {
}

void cContaCorrente :: menu(){
    Conta vet [3];
    int posConta=0, cpf=0;
    int opc;
    
    do{ 
        cout << "Digite 1 para criar conta" <<endl;
        cout << "Digite 2 para pesquisar conta" <<endl;
        cout << "Digite 3 para imprimir conta" <<endl;
        cout << "Digite 4 para sair" <<endl;
        cin >> opc;
    
        switch(opc){
            case 1: this ->iniciarConta(vet);break;
            case 2: this ->operacoesConta(vet);break;
            case 3: 
                cout<<"Digite CPF";
                cin>>cpf;
                posConta = this->pesqSeq(vet, cpf);
                this->imprimirConta(vet, posConta);break;
            case 4: break;
        }
    }while ((opc>=1)||(opc<=4));
}

void cContaCorrente :: iniciarConta(Conta *vet, int i){
    cout << "Digite o nome: ";
    cin >> vet[i].nome;
    cout << "Digite o cpf: ";
    cin >> vet[i].cpf;
    cout << "Digite o saldo da conta: ";
    cin >> vet[i].saldo;
}

void cContaCorrente :: imprimirConta(Conta* vet, int posConta){
    
    cout << "Conta: " << posConta << endl;
    cout << vet [posConta].nome;
    cout << vet [posConta].cpf;
    cout << vet [posConta].saldo;
}
int cContaCorrente::pesqSeq(Conta *vet, int cpf){
    for(int i=0;i<=2;i++){
        if(cpf == vet[i].cpf)
            return i;
    }        
    return -1;
}
void cContaCorrente :: operacoesConta(Conta* vet){
    int pesqCPF=0, opcao=0, posicao;
    float valor=0.0;
    
    cout<<"Digite o CPF do cliente: "<<endl;
    cin>>pesqCPF;
    
    posicao = this->pesqSeq(Conta *vet, int cpf);
    
    if(posicao!=-1){
        cout<<"Digite 1 para saque: "<<endl;
        cout<<"Digite 2 para deposito"<<endl;
        cin>>opcao;
        if(opcao == 1){
            cout<<"Digite o valor do saque: "<<endl;
            cin>>valor;
            vet[posicao].saldo-=valor;   
        }else
            if(opcao == 2){
                cout<<"Digite o valor do deposito: "<<endl;
                cin>>valor;
                vet[posicao].saldo+=valor; 
            }
    }else
        cout<<"Cliente não existe";
    
    this->imprimirConta(vet, posicao);

}
