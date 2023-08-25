/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cMatricula.h
 * Author: gbiz0
 *
 * Created on 18 de agosto de 2023, 11:29
 */

#ifndef CMATRICULA_H
#define CMATRICULA_H

#include <string>
using namespace std;

struct Matricula{
    string nome;
    int matricula;
    float nota[2];
    float media;
};

class cMatricula {
public:
    Matricula array [2];    
    void lerMatricula();
    void media();
    void mostrarMatricula();
    cMatricula();
    cMatricula(const cMatricula& orig);
    virtual ~cMatricula();
private:

};

#endif /* CMATRICULA_H */

