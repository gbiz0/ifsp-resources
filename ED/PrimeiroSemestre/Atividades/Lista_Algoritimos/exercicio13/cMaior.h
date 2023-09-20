/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cMaior.h
 * Author: gbiz0
 *
 * Created on 20 de setembro de 2023, 10:50
 */

#ifndef CMAIOR_H
#define CMAIOR_H

class cMaior {
public:
    void lerDados();
    void calcular();
    float a, b, c;
    cMaior();
    cMaior(const cMaior& orig);
    virtual ~cMaior();
private:

};

#endif /* CMAIOR_H */

