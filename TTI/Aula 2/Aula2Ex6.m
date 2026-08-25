clc;
clear;

a = imread('../imagens/Lena512.bmp');
b = imnoise(a, 'gaussian');
c = imnoise(a,'gaussian', 0, 0.003);
d = imnoise(a, 'salt & pepper');
e = imnoise(a, 'salt & pepper', 0.05);


figure;
subplot(3, 3, 2), imshow(a), title('Original Image');
subplot(3, 3, 4), imshow(b), title('Gaussian Noise (0, 0.01)');
subplot(3, 3, 6), imshow(c), title('Gaussian Noise (0, 0.003)');
subplot(3, 3, 7), imshow(d), title('Salt & Pepper Noise (0.05)');
subplot(3, 3, 9), imshow(e), title('Salt & Pepper Noise (0.05)');
