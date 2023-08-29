/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cAluno.h
 * Author: gbiz0
 *
 * Created on 18 de agosto de 2023, 10:09
 */

#ifndef CALUNO_H
#define CALUNO_H

#include <string>
using namespace std;

struct Dados{
    string nome;
    int idade;
    char sexo;
    float nota[3];
};

class cAluno {
public:
    Dados array[2];
    void lerDados();
    void mostrarDados();
    cAluno();
    cAluno(const cAluno& orig);
    virtual ~cAluno();
private:

};

#endif /* CALUNO_H */

