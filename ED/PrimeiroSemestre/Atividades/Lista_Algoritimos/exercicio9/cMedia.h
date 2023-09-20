/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   cMedia.h
 * Author: gbiz0
 *
 * Created on 20 de setembro de 2023, 10:21
 */

#ifndef CMEDIA_H
#define CMEDIA_H

class cMedia {
public:
    void lerDados();
    void calcular();
    
    float n1,n2,n3;
    cMedia();
    cMedia(const cMedia& orig);
    virtual ~cMedia();
private:

};

#endif /* CMEDIA_H */

