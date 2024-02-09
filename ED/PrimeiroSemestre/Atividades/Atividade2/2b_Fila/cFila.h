/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cFila.h
 * Author: gbiz0
 *
 * Created on 30 de novembro de 2023, 20:51
 */

#ifndef CFILA_H
#define CFILA_H

struct no {
    int valor;
    no *prox;
    
};
class cFila {
public:
    void inserir();
    void menu();
    void listar();
    void pesquisar();
    void remover();
    
    no *inicio, *fim, *aux;
    cFila();
    cFila(const cFila& orig);
    virtual ~cFila();
private:

};

#endif /* CFILA_H */

