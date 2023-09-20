/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cCarro.h
 * Author: gbiz0
 *
 * Created on 19 de setembro de 2023, 14:00
 */

#ifndef CCARRO_H
#define CCARRO_H

class cCarro {
public:
    float custo_f;
    
    void lerDados();
    void imprimir();
    cCarro();
    cCarro(const cCarro& orig);
    virtual ~cCarro();
private:

};

#endif /* CCARRO_H */

