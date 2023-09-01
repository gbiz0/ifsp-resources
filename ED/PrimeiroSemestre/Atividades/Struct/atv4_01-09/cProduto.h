/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cProduto.h
 * Author: gbiz0
 *
 * Created on 1 de setembro de 2023, 11:12
 */

#ifndef CPRODUTO_H
#define CPRODUTO_H
#include <string>
using namespace std;

struct Produto{
        string nome;
        int    cod;
        int    preco;
    };
    
class cProduto {
public:
    Produto vet[2];
    void lerProduto();
    void imprimirProduto(Produto *vet, int pesqCod, int quant);
    
    cProduto();
    cProduto(const cProduto& orig);
    virtual ~cProduto();
private:

};

#endif /* CPRODUTO_H */

