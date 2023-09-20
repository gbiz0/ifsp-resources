/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cTempo.h
 * Author: gbiz0
 *
 * Created on 19 de setembro de 2023, 13:45
 */

#ifndef CTEMPO_H
#define CTEMPO_H

class cTempo {
public:
    int segundos;
    void lerDados();
    void imprimir();
    cTempo();
    cTempo(const cTempo& orig);
    virtual ~cTempo();
private:

};

#endif /* CTEMPO_H */

