/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cProduto.h
 * Author: gbiz0
 *
 * Created on 11 de agosto de 2023, 09:16
 */

#ifndef CPRODUTO_H
#define CPRODUTO_H

class cProduto {
public:
    void menu();
    void lerCod();
    float calcularCod(int cod, int quant);
    
    cProduto();
    cProduto(const cProduto& orig);
    virtual ~cProduto();
private:

};

#endif /* CPRODUTO_H */

