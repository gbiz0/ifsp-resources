/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cLanche.h
 * Author: gbiz0
 *
 * Created on 20 de setembro de 2023, 11:10
 */

#ifndef CLANCHE_H
#define CLANCHE_H

class cLanche {
public:
    int pedido, qtd;
    
    void lerDados();
    void imprimir();
    
    cLanche();
    cLanche(const cLanche& orig);
    virtual ~cLanche();
private:

};

#endif /* CLANCHE_H */

