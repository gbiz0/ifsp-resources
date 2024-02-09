/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cFibonacci.cpp
 * Author: gbiz0
 * 
 * Created on 30 de novembro de 2023, 19:15
 */

#include "cFibonacci.h"
#include <iostream>
using namespace std;

cFibonacci::cFibonacci() {
}

cFibonacci::cFibonacci(const cFibonacci& orig) {
}

cFibonacci::~cFibonacci() {
}

int cFibonacci :: calcular (int n) {    
    if (n == 1) {
        return 1;
    } 
    else if (n == 0){
        return 0;
    }
    
    else {
        
        return this->calcular (n - 1) + this->calcular (n - 2);
    }
}
