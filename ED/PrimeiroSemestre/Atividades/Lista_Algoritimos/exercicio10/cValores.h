/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cValores.h
 * Author: gbiz0
 *
 * Created on 20 de setembro de 2023, 10:27
 */

#ifndef CVALORES_H
#define CVALORES_H

class cValores {
public:
    void lerDados();
    void calculo();
    
    float a, b, c;
    
    cValores();
    cValores(const cValores& orig);
    virtual ~cValores();
private:

};

#endif /* CVALORES_H */

