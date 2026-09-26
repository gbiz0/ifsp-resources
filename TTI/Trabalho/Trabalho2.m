clear;
clc;

img = imresize(rgb2gray(imread('placa1.bmp')), 0.5);

imwrite(img, 'placa5kb.jpg', 'Quality', 30);

figure(1), imshow(img), title('Placa 5kb');