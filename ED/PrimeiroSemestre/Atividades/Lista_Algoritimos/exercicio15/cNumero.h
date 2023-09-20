/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cNumero.h
 * Author: gbiz0
 *
 * Created on 20 de setembro de 2023, 11:02
 */

#ifndef CNUMERO_H
#define CNUMERO_H

class cNumero {
public:
    void lerDados();
    void calcular();
    int numero;
    cNumero();
    cNumero(const cNumero& orig);
    virtual ~cNumero();
private:

};

#endif /* CNUMERO_H */

