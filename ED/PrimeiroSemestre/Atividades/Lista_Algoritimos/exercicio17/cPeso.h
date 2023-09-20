/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cPeso.h
 * Author: gbiz0
 *
 * Created on 20 de setembro de 2023, 11:15
 */

#ifndef CPESO_H
#define CPESO_H

class cPeso {
public:
    void lerDados();
    void imprimir();
    float altura;
    char sexo;
    cPeso();
    cPeso(const cPeso& orig);
    virtual ~cPeso();
private:

};

#endif /* CPESO_H */

