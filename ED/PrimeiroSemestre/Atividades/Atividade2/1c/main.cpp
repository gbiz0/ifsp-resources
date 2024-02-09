/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/main.cc to edit this template
 */

/* 
 * File:   main.cpp
 * Author: gbiz0
 *
 * Created on 30 de novembro de 2023, 19:14
 */

#include <cstdlib>

#include "cFibonacci.h"
#include <iostream>
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    int n;
    cFibonacci obj;
    cin >> n;
    
    
    cout << obj.calcular(n);
    return 0;
}

