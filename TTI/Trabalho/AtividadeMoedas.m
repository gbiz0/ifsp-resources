clear all;
clc;

imgCoin = imread('moeda1.bmp');
grayCoin = rgb2gray(imgCoin);

binaryCoin = imbinarize(grayCoin);
binaryCoin = imfill(binaryCoin, 'holes');
cleanedCoin = imopen(binaryCoin, strel('disk', 15));

distance = -bwdist(~cleanedCoin);
L = watershed(distance);
cleanedCoin(L == 0) = 0; 

boundaries = bwboundaries(cleanedCoin);

figure(1);
subplot(1, 3, 1), imshow(imgCoin), title('Imagem Original')
subplot(1, 3, 2), imshow(grayCoin), title('Imagem Cinza');
subplot(1, 3, 3), imshow(cleanedCoin), title('Imagem limpa binarizada');

numCoins = length(boundaries);
disp(['Foram encontradas ', num2str(numCoins), ' moedas']);