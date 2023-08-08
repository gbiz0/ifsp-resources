/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cCalculo.h
 * Author: jardi
 *
 * Created on 7 de Agosto de 2023, 22:17
 */

#ifndef CCALCULO_H
#define CCALCULO_H

class cCalculo {
public:
     int a, b, c;
     
    cCalculo();
    cCalculo(const cCalculo& orig);
    virtual ~cCalculo();
    
    void lerNum();
    float calcularNum();
private:

};

#endif /* CCALCULO_H */

