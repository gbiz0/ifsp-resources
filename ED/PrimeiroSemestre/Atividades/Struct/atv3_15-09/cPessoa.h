/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cPessoa.h
 * Author: gbiz0
 *
 * Created on 15 de setembro de 2023, 08:41
 */

#ifndef CPESSOA_H
#define CPESSOA_H
#include <string>
using namespace std;

struct Pessoa{
    string nome;
    int cpf;
};
class cPessoa {
public:
    lerDados();
    procurarDados();
    
    cPessoa();
    cPessoa(const cPessoa& orig);
    virtual ~cPessoa();
private:

};

#endif /* CPESSOA_H */

