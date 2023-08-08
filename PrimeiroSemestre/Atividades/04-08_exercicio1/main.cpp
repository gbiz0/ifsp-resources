/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/main.cc to edit this template
 */

/* 
 * File:   main.cpp
 * Author: jardi
 *
 * Created on 7 de Agosto de 2023, 20:40
 */

#include <cstdlib>
#include <iostream>
#include "cPlano.h"
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    cPlano obj;
    obj.lerPontos();
    cout << obj.calcularDE();
    return 0;
}

