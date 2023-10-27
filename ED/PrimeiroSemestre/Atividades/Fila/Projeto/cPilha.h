/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cPilha.h
 * Author: gbiz0
 *
 * Created on 27 de outubro de 2023, 10:25
 */

#ifndef CPILHA_H
#define CPILHA_H

class cPilha {
public:
    cPilha();
    cPilha(const cPilha& orig);
    virtual ~cPilha();
    
    struct nodo{
	int elem;
	struct nodo *ant;//O próximo elemento a ser chamado tem que ser do tipo nodo, no caso *prox armazena recebe o endereco de proximo nodo
    } *topo, *aux;
    
    bool vazio(struct nodo *campo);
    void insere(void);
    void removr(void);
    void listar(void);
    void menu(void);
private:

};

#endif /* CPILHA_H */

