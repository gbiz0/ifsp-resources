/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cAluno.h
 * Author: gbiz0
 *
 * Created on 20 de setembro de 2023, 10:55
 */

#ifndef CALUNO_H
#define CALUNO_H

class cAluno {
public:
    void lerDados();
    void calcular();
    int cod;
    float nota1, nota2, nota3;
    cAluno();
    cAluno(const cAluno& orig);
    virtual ~cAluno();
private:

};

#endif /* CALUNO_H */

