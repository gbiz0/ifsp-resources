clear;
clc;

img = imread('placa2terra.bmp');
imgGray = rgb2gray(img);

level = graythresh(imgGray);
imgBW = imbinarize(imgGray, level);
imgBW = imcomplement(imgBW);

SE = [1 1 1 1 1 1 1 1 1;
      1 1 1 1 1 1 1 1 1;
      1 1 1 1 1 1 1 1 1;
      1 1 1 1 1 1 1 1 1;
      1 1 1 1 1 1 1 1 1;
      1 1 1 1 1 1 1 1 1;
      1 1 1 1 1 1 1 1 1;
      1 1 1 1 1 1 1 1 1;
      1 1 1 1 1 1 1 1 1;];

imgErode = imerode(imgBW, SE);
imgAbertura = imdilate(imgErode, SE);

imshow(imgAbertura);
