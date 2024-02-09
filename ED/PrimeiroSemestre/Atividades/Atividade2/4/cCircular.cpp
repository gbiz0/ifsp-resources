/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cCircular.cpp
 * Author: gbiz0
 * 
 * Created on 30 de novembro de 2023, 22:03
 */

#include "cCircular.h"
#include <iostream>
using namespace std;
cCircular::cCircular() {
}

cCircular::cCircular(const cCircular& orig) {
}

cCircular::~cCircular() {
}

void cCircular :: inserir(){
    
    this->aux = (struct *no) malloc (sizeof(this->aux));
    
    cin >> this->aux->valor;
    if (inicio == NULL) {
        this->inicio = this->aux;
    } else{
        prox = aux;
    }

}