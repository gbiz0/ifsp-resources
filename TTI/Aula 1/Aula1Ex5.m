clear all;
clc;

img = imread('../imagens/Lena512.bmp');

imgQuaternaria = img;

for i = 1:512
    for j = 1:512
        if img(i, j) <= 70
            imgQuaternaria(i, j) = 30;
        elseif img(i, j) >= 140
            imgQuaternaria(i, j) = 0;
        elseif img(i, j) >= 200
            imgQuaternaria(i, j) = 60;
        elseif img(i, j) >= 126
            imgQuaternaria(i, j) = 90;
        else
            imgQuaternaria(i, j) = 180;
        end
    end
end

figure(1), imshow(imgQuaternaria);