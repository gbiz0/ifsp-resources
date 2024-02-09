/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cCircular.h
 * Author: gbiz0
 *
 * Created on 30 de novembro de 2023, 22:03
 */

#ifndef CCIRCULAR_H
#define CCIRCULAR_H

struct no{
    int valor;
    struct no *prox;
}*inicio;

class cCircular {
public:
    void inserir();
    void excluir();
    void listar();
    cCircular();
    cCircular(const cCircular& orig);
    virtual ~cCircular();
private:

};

#endif /* CCIRCULAR_H */

