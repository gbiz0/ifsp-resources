/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cEnade.cpp
 * Author: jardi
 * 
 * Created on 7 de Agosto de 2023, 20:18
 */

#include "cEnade.h"
#include <iostream>
#include <cstdlib>
#include <locale>
#include <cmath>
#include <iomanip>

cEnade::cEnade() {
}

cEnade::cEnade(const cEnade& orig) {
}

cEnade::~cEnade() {
}


void cEnade::insert(){
    int I, J, C;
    
    C = 0;
    
    for (I = 0; I < 3; I++){
        for (J = 0; J < 4; J++){
            C++;
            M[I][J] = C;
        }
    }
    
    for (I = 0; I < 3; I++){
        for (J = 0; J < 4; J++){
            C = M[2-I][3-J];
            M[I][J] = C;
        }
    }
}

void cEnade::print(){
    for (int I = 0; I < 3; I++){
        for (int J = 0; J < 4; J++){
            
        }
    }
}