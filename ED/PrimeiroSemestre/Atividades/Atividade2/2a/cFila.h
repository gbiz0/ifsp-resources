/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cFila.h
 * Author: gbiz0
 *
 * Created on 30 de novembro de 2023, 20:24
 */

#ifndef CFILA_H
#define CFILA_H

class cFila {
public:
    int val[50];
    int contador = 0;
    void inserir();
    void remover();
    cFila();
    cFila(const cFila& orig);
    virtual ~cFila();
private:

};

#endif /* CFILA_H */

