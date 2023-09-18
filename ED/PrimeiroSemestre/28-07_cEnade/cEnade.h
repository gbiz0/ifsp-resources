/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cEnade.h
 * Author: jardi
 *
 * Created on 7 de Agosto de 2023, 20:18
 */

#ifndef CENADE_H
#define CENADE_H

class cEnade {
public:
    int M[3][4];
    void insert();
    void print();
    
    cEnade();
    cEnade(const cEnade& orig);
    virtual ~cEnade();
private:

};

#endif /* CENADE_H */

