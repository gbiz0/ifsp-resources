/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   cAluno.cpp
 * Author: gbiz0
 * 
 * Created on 18 de agosto de 2023, 10:09
 */

#include "cAluno.h"
#include <iostream>
#include <valarray>
using namespace std;

cAluno::cAluno() {
}

cAluno::cAluno(const cAluno& orig) {
}

cAluno::~cAluno() {
}

void cAluno :: lerDados(){
    int i=0;
    while (i<2){
        cout << "Nome: "; 
        cin >> this -> array[i].nome;
        cout << "Idade: "; 
        cin >> this -> array[i].idade;
        cout << "Sexo: "; 
        cin >> this -> array[i].sexo;
        i++;
        
        for (int j = 1; j <= 3; j++) {
            cout << "Nota "<<j<<": "; 
            cin >> this  -> array[i].nota[j];
        }
    }
}  

void cAluno :: mostrarDados(){
    int i=0, j=0;
    while (i<2) {
        cout << "----------------Aluno "<< i+1 <<"-------------------------" << endl;
        cout << "Nome Aluno: " << this -> array[i].nome << endl;
        cout << "Idade Aluno: " << this -> array[i].idade << endl;
        cout << "Sexo Aluno: " << this -> array[i].sexo << endl;
        i++;
        for (int j = 1; j <= 2; j++) {
        cout << "Nota "<< j <<" Aluno: " << this -> array[i].nota[j] << endl;
        }
    }
}
