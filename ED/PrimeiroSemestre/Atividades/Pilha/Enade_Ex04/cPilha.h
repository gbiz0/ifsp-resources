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

struct no{
    int valor;
    struct no *ant;
};

class cPilha {
    
    
public:
     no *topo, *aux;
    
    cPilha();
    void menu();
    void inserir();
    void listar();
    void remover();
    no* meio();
    bool vazio(struct no *campo);
    
    cPilha(const cPilha& orig);
    virtual ~cPilha();
private:

};

#endif /* CPILHA_H */

