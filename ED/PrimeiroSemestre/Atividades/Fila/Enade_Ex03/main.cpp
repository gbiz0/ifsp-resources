/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/main.cc to edit this template
 */

/* 
 * File:   main.cpp
 * Author: gbiz0
 *
 * Created on 17 de novembro de 2023, 07:29
 */

#include <cstdlib>
#include "cFila.h"
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    cFila obj;
    obj.menu();
    obj.inserir();
    obj.listar();
    obj.remover();
    obj.pesquisar();

    return 0;
}

