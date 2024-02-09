/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cRecurpilha.h
 * Author: gbiz0
 *
 * Created on 30 de novembro de 2023, 20:03
 */

#ifndef CRECURPILHA_H
#define CRECURPILHA_H
struct no{
    int valor;
    struct no *ant;
};
class cRecurpilha {
public:
    no *topo, *aux;
    void menu();
    void inserir();
    void listar(struct no* elem);
    void remover();
    no* meio();
    bool vazio(struct no *campo);
    cRecurpilha();
    cRecurpilha(const cRecurpilha& orig);
    virtual ~cRecurpilha();
private:

};

#endif /* CRECURPILHA_H */

