/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cRecursividade.cpp
 * Author: gbiz0
 * 
 * Created on 15 de setembro de 2023, 09:23
 */

#include "cRecursividade.h"
using namespace std;

cRecursividade::cRecursividade() {
}

cRecursividade::cRecursividade(const cRecursividade& orig) {
}

cRecursividade::~cRecursividade() {
}

int cRecursividade :: fatorial(int a){
    if (a > 1){
        return (a * fatorial (a - 1));
    }else 
        return (1);
}

