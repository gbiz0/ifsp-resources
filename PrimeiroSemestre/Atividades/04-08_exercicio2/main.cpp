/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/main.cc to edit this template
 */

/* 
 * File:   main.cpp
 * Author: jardi
 *
 * Created on 4 de Agosto de 2023, 11:01
 */

#include <cstdlib>
#include <iostream>
#include "cCalculo.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    cCalculo obj;
    obj.lerNum();
    cout << obj.calcularNum();
    return 0;
}

