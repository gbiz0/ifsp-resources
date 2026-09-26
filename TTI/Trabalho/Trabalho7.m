clear all;
clc;

img = imread('lenaRGB.png');
imgGray = rgb2gray(img);

for i = 1:50
    for j = 1:100
        imgGray(i, j) = 127;
    end
end

[M, N] = size(imgGray);

imgGrayBin = imgGray;
for i = 1:M
    for j = 1:N
        if imgGrayBin(i, j) > 127
            imgGrayBin(i, j) = 255;
        else
            imgGrayBin(i, j) = 0;
        end
    end
end

imgGray4Bin = zeros(M, N, 'uint8');
for i = 1:M
    for j = 1:N
        if imgGray(i, j) <= 70
            imgGray4Bin(i, j) = 0;
        elseif imgGray(i, j) <= 140
            imgGray4Bin(i, j) = 100;
        elseif imgGray(i, j) <= 200
            imgGray4Bin(i, j) = 180;
        else
            imgGray4Bin(i, j) = 255;
        end
    end
end

imgGray8Bin = (imgGray / 32) * 32;

figure(1)
subplot(2,2,1), imshow(imgGray), title('Imagem com o quadrado');
subplot(2,2,2), imshow(imgGrayBin), title('Binarizada');
subplot(2,2,3), imshow(imgGray4Bin), title('4 de Cinza');
subplot(2,2,4), imshow(imgGray8Bin), title('8 de Cinza');