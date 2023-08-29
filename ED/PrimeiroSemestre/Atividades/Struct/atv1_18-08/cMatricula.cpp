/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cMatricula.cpp
 * Author: gbiz0
 * 
 * Created on 18 de agosto de 2023, 11:29
 */

#include "cMatricula.h"

#include <iostream>
#include <valarray>
using namespace std;

cMatricula::cMatricula() {
}

cMatricula::cMatricula(const cMatricula& orig) {
}

cMatricula::~cMatricula() {
}

void cMatricula :: lerMatricula(){
    int i=0;
    while (i<2){
        cout << "Nome: "; 
        cin >> this -> array[i].nome;
        cout << "Matricula: "; 
        cin >> this -> array[i].matricula;
        i++;
        
        for (int j = 0; j < 2; j++) {
            cout << "Nota "<<j+1<<": "; 
            cin >> this  -> array[i].nota[j];
        }
    }
}  

void cMatricula :: mostrarMatricula(){
    int i=0, j=0;
    while (i<2) {
        cout << "----------------Aluno "<< i+1 <<"-------------------------" << endl;
        cout << "Nome do Aluno: " << this -> array[i].nome << endl;
        cout << "Matricula do Aluno: " << this -> array[i].matricula << endl;
        cout << "Média: " << (this -> array[i].nota[0] + this -> array[i].nota[1]) /2 << endl;
        i++;
    }
}