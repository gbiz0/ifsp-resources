clc; clear;
imagem = imread('imgRuido.png');


filtro = [1, 1, 1, 1, 1; ...
          1, 1, 1, 1, 1; ...
          1, 1, 1, 1, 1; ...
          1, 1, 1, 1, 1; ...
          1, 1, 1, 1, 1] / 25;

img = conv2(double(imagem), filtro, 'same'); 
img = uint8(img);

figure(1), imshow(imagem);
figure(2), imshow(img);
