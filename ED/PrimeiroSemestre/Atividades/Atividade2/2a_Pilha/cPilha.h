/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cPilha.h
 * Author: gbiz0
 *
 * Created on 30 de novembro de 2023, 20:38
 */

#ifndef CPILHA_H
#define CPILHA_H

class cPilha {
public:
    int val[50];
    int contador = 0;
    
    void inserir();
    void remover();
    cPilha();
    cPilha(const cPilha& orig);
    virtual ~cPilha();
private:

};

#endif /* CPILHA_H */

