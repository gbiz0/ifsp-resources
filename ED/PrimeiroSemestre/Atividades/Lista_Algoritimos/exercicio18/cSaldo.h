/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cSaldo.h
 * Author: gbiz0
 *
 * Created on 20 de setembro de 2023, 11:31
 */

#ifndef CSALDO_H
#define CSALDO_H

class cSaldo {
public:
    void lerDados();
    void calcular();
    float saldoMedio;
    cSaldo();
    cSaldo(const cSaldo& orig);
    virtual ~cSaldo();
private:

};

#endif /* CSALDO_H */

