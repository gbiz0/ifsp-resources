clear all;
clc;

img = imread('../imagens/Lena512.bmp');

imgQuad = img;
imgClara = img;
imgEscura = img;

for i = 1:35
    for j = 1:55
        imgQuad(i, j) = 0; % Example operation: dimming the pixel
    end
end

for i = 1:512
    for j = 1:512
        imgClara(i, j) = img(i,j) + 50;
    end
end

for i = 1:512
    for j = 1:512
        imgEscura(i, j) = img(i,j) - 50;
    end
end


figure(1), imshow(img);
figure(2), imshow(imgQuad);
figure(3), imshow(imgClara);
figure(4), imshow(imgEscura);
