clear all;
clc;

imgIF = imread('../imagens/if.jpg');

imgIFG = rgb2gray(imgIF);

figure(1), imshow(imgIF);
figure(2), imshow(imgIFG);