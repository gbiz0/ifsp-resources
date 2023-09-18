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

void cContaCorrente :: receberDados(){
    int i=0;
    Conta vet[3];
    while(i<3){
        cout << "Nome: ";
        cin>>vet[i].nome;
        cout << "CPF: ";
        cin>>vet[i].cpf;
        cout << "Deposito Inicial: ";
        cin>>vet[i].saldo;
        i++;
    }
    this->menu(vet);
}

void cContaCorrente :: menu(Conta *vet){
    int i;
    int posConta=0, cpf=0;
    int opc;
    
        cout << "Digite 1 para criar conta" <<endl;
        cout << "Digite 2 para pesquisar conta" <<endl;
        cout << "Digite 3 para imprimir conta" <<endl;
        cout << "Digite 4 para sair" <<endl;
        cin >> opc;
        
        if (opc == 1) {
            this->iniciarConta(vet, i);
        }else if(opc == 2){
            this->operacoesConta(vet);
        }else if(opc == 3){
            this->imprimirConta(vet, posConta);
        }else if(opc == 4){
            cout << "Saindo...";
        }else {
            cout << "Opção inválida!!";
        }
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
    
    cout << "Número da Conta: " << posConta+1 << endl;
    cout << vet [posConta].nome << endl;
    cout << vet [posConta].cpf << endl;
    cout << vet [posConta].saldo << endl;
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
    
    posicao = this->pesqSeq(vet, pesqCPF);
    
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
