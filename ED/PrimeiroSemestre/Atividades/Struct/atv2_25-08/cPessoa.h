/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cPessoa.h
 * Author: gbiz0
 *
 * Created on 25 de agosto de 2023, 09:07
 */

#ifndef CPESSOA_H
#define CPESSOA_H

#include <string>
using namespace std;

class cPessoa {
public:
    struct Pessoa{
        string nome;
        int    cpf;
        float  altura, peso;
        string sexo;
    }vet[3];

    cPessoa();
    cPessoa(const cPessoa& orig);
    virtual ~cPessoa();
    
    void  receberDados();
    void  ordenarPessoas(Pessoa *vet, int quant); 
    void  imprimirLista(Pessoa *vet, int quant);
    int   localizaPessoa(Pessoa *vet, int pesqCPF, int quant);
    int   PesquisaBinaria ( int k[], int chave , int N);
private:

};

#endif /* CPESSOA_H */

