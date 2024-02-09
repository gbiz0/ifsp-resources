/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cDupla.h
 * Author: gbiz0
 *
 * Created on 30 de novembro de 2023, 21:11
 */

#ifndef CDUPLA_H
#define CDUPLA_H

struct{
    int valor;
    struct no *prox;
    struct no *ant;
    };
    
class cDupla {
public:
    void menu();
    void inserir();
    void listar();
    void remover();
    void pesquisar();
    no *inicio, *aux, *fim;
    cDupla();
    cDupla(const cDupla& orig);
    virtual ~cDupla();
private:

};

#endif /* CDUPLA_H */

