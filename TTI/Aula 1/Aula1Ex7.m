img = imread('../imagens/Lena512.bmp');
imgIF = imread('../imagens/if30.bmp')

imgQuad = img;
[M,N] = size (img);

for i = 1:M
    for j = 1:N
        imgQuad(i, j) = imgIF (i,j);
    end
end

figure(1), imshow(img);
figure(2), imshow(imgQuad);