clc;
clear;

a = imread('../imagens/Lena512.bmp');
b = imread(a,[100,100,180,180]);
figure(1), subplot(2,1,1), colormap(gray), imshow(a);