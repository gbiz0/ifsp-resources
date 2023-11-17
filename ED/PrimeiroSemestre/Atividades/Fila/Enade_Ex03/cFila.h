/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cFila.h
 * Author: gbiz0
 *
 * Created on 17 de novembro de 2023, 07:29
 */

#ifndef CFILA_H
#define CFILA_H

class cFila {
    struct no{
        int valor;
        struct no *prox;
    }*inicio, *aux, *fim;
    
    
public:
    cFila();
    void menu();
    void inserir();
    void listar();
    void verificar();
    void pesquisar();
    bool existe(int valor);
    void remover();
    cFila(const cFila& orig);
    virtual ~cFila();
private:

};

#endif /* CFILA_H */

