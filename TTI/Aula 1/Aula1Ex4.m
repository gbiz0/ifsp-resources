clear all;
clc;

img = imread('../imagens/Lena512.bmp');

imgBinaria = img;

for i = 1:512
    for j = 1:512
        if img (i,j) > 127
            imgBinaria(i, j) = 255;
        else
            imgBinaria(i, j) = 0;
        end
    end
end


figure(1), imshow(imgBinaria);