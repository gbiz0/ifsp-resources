/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cFila.cpp
 * Author: gbiz0
 * 
 * Created on 30 de novembro de 2023, 20:24
 */

#include "cFila.h"

cFila::cFila() {
}

cFila::cFila(const cFila& orig) {
}

cFila::~cFila() {
}
void cFila :: inserir(){
        int n;
        std::cin >> n;
        
        this->val[contador] = n;
        this->contador++;
    }
void cFila :: remover() {
        this->val[0] = NULL;
    }