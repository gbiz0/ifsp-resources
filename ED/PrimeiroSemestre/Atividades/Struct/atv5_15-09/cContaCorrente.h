/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cContaCorrente.h
 * Author: gbiz0
 *
 * Created on 15 de setembro de 2023, 11:16
 */

#ifndef CCONTACORRENTE_H
#define CCONTACORRENTE_H
#include <string>
using namespace std;

struct Conta{
    string nome;
    int cpf;
    float saldo;
};
class cContaCorrente {
public:
    void menu();
    void iniciarConta(Conta *vet, int i);
    void operacoesConta(Conta *vet);
    void imprimirConta(Conta* vet, int posConta);
    void pesqSeq(Conta *vet, int cpf);
    
    cContaCorrente();
    cContaCorrente(const cContaCorrente& orig);
    virtual ~cContaCorrente();
private:

};

#endif /* CCONTACORRENTE_H */

