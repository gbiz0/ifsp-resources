/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cFila.h
 * Author: gbiz0
 *
 * Created on 27 de outubro de 2023, 10:24
 */

#ifndef CFILA_H
#define CFILA_H

class cFila {
public:
    struct nodo{
	int elem;
	struct nodo *prox;
    } *inicio, *aux, *fim;
    
    cFila();
    cFila(const cFila& orig);
    virtual ~cFila();
    void inserir();
    bool vazio(struct nodo *campo);
    void removr(void);
    void listar(void);
    void menu(void);
private:

};

#endif /* CFILA_H */

