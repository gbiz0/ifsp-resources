/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cPilha.cpp
 * Author: gbiz0
 * 
 * Created on 30 de novembro de 2023, 20:38
 */

#include "cPilha.h"

cPilha::cPilha() {
}

cPilha::cPilha(const cPilha& orig) {
}

cPilha::~cPilha() {
}
void cPilha :: inserir(){
        int n;
        std::cin >> n;
        
        this->val[contador] = n;
        this->contador++;
}
void cPilha :: remover() {
        this->val[0] != NULL;
}