clear all;
clc;

img = imread('../imagens/Lena512.bmp');

imgQuad = img;

for i = 1:55
    for j = 1:35
        imgQuad(i, j) = 0; % Example operation: dimming the pixel
    end
end

figure(1), imshow(img);
figure(2), imshow(imgQuad);
title('Modified Image');