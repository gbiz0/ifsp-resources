/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cNotas.h
 * Author: gbiz0
 *
 * Created on 20 de setembro de 2023, 11:51
 */

#ifndef CNOTAS_H
#define CNOTAS_H

class cNotas {
public:
    void lerNotas();
    void calcular();
    int tipo;
    float nota1, nota2, nota3;
    cNotas();
    cNotas(const cNotas& orig);
    virtual ~cNotas();
private:

};

#endif /* CNOTAS_H */

