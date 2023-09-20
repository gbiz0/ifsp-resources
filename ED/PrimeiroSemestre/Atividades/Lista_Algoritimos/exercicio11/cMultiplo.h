/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cMultiplo.h
 * Author: gbiz0
 *
 * Created on 20 de setembro de 2023, 10:39
 */

#ifndef CMULTIPLO_H
#define CMULTIPLO_H

class cMultiplo {
public:
    void lerDados();
    void calculo();
    
    int a, b;
    cMultiplo();
    cMultiplo(const cMultiplo& orig);
    virtual ~cMultiplo();
private:

};

#endif /* CMULTIPLO_H */

