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

struct Pessoa{
    string nome;
    int    cpf;
    float  altura, peso;
    string sexo;
};

class cPessoa {
public:
    cPessoa();
    cPessoa(const cPessoa& orig);
    virtual ~cPessoa();
    
    void  receberDados();
    void  ordenarPessoas(Pessoa pArray[], int n); 
    void  imprimirLista(Pessoa *array, int quant);
    float imc(Pessoa *array, int i);
    int   localizaPessoa(Pessoa *array, int pesqCPF, int quant);
private:

};

#endif /* CPESSOA_H */

