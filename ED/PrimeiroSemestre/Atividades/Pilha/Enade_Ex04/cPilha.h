/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cPilha.h
 * Author: gbiz0
 *
 * Created on 17 de novembro de 2023, 09:57
 */

#ifndef CPILHA_H
#define CPILHA_H

class cPilha {
    
    struct no{
        int valor;
        struct no *ant;
    }*topo, *aux;
    
public:
    cPilha();
    void menu();
    void inserir();
    void listar();
    void remover();
    void meio();
    cPilha(const cPilha& orig);
    virtual ~cPilha();
private:

};

#endif /* CPILHA_H */

