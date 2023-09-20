/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cNadador.h
 * Author: gbiz0
 *
 * Created on 20 de setembro de 2023, 10:45
 */

#ifndef CNADADOR_H
#define CNADADOR_H

class cNadador {
public:
    void lerDados();
    void calcular();
    
    int idade;
    
    cNadador();
    cNadador(const cNadador& orig);
    virtual ~cNadador();
private:

};

#endif /* CNADADOR_H */

