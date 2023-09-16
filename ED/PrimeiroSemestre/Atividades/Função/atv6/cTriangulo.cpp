/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cTriangulo.cpp
 * Author: gbiz0
 * 
 * Created on 16 de setembro de 2023, 08:58
 */

#include "cTriangulo.h"
#include <iostream>
using namespace std;
cTriangulo::cTriangulo() {
}

cTriangulo::cTriangulo(const cTriangulo& orig) {
}

cTriangulo::~cTriangulo() {
}

void cTriangulo :: lerDados(){
    double x, y, z;
    
    cout << "Digite o comprimento do lado X: ";
    cin >> x;
    
    cout << "Digite o comprimento do lado Y: ";
    cin >> y;
    
    cout << "Digite o comprimento do lado Z: ";
    cin >> x;
    
    if (x + y > z && x + z > y && y + z > x) {        
        if (x == y && y == z) {
            cout << "Triângulo Equilátero" << endl;
        } else if (x == y || y == z || x == z) {
            cout << "Triângulo Isósceles" << endl;
        } else {
            cout << "Triângulo Escaleno" << endl;
        }
    }
}