/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cPlano.h
 * Author: jardi
 *
 * Created on 7 de Agosto de 2023, 20:40
 */

#ifndef CPLANO_H
#define CPLANO_H

class cPlano {
public:
     int x1, y1, x2,  y2;
    cPlano();
    cPlano(const cPlano& orig);
    virtual ~cPlano();
    
    void lerPontos();
    float calcularDE();
private:

};

#endif /* CPLANO_H */

