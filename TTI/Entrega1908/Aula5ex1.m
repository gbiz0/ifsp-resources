clear;
clc;

img = imread("lenaRGB.png");
message = imread("mensagem512.bmp");

imgR = img(:,:,1);
imgG = img(:,:,2);
imgB = img(:,:,3);

[m, n] = size(imgR);

imgR_mark = imgR;

for i = 1:m
    for j = 1:n
        imgR_mark(i,j) = bitset(imgR(i,j), 1, message(i,j));
    end
end

markImage = cat(3, imgR_mark, imgG, imgB);
imwrite(markImage, '/Results/markColor.bmp');

imgMarcadaR = markImage(:,:,1);
messageOutput = zeros(m,n);

for i = 1:m
    for j = 1:n
        messageOutput(i,j) = bitget(imgMarcadaR(i,j), 1);
    end
end

messageOutput = messageOutput * 255;

figure(1);
subplot(2, 3, 1); imshow(img);  title('1. Imagem Original');
subplot(2, 3, 2); imshow(message); title('2. Mensagem Original');
subplot(2, 3, 3); imshow(markImage);   title('3. Imagem com Mensagem Inserida');
subplot(2, 3, 4); imshow(markImage);   title('4. Imagem Marcada');
subplot(2, 3, 5); imshow(messageOutput); title('5. Mensagem Extraída (Íntegra)');

imagemAdulterada = markImage;

for i = 50:150
    for j = 50:150
        imagemAdulterada(i,j,:) = 0;
    end
end

imgAdulteradaR = imagemAdulterada(:,:,1);
mensagemAdulterada = zeros(m,n);

for i = 1:m
    for j = 1:n
        mensagemAdulterada(i,j) = bitget(imgAdulteradaR(i,j), 1);
    end
end

mensagemAdulterada = mensagemAdulterada * 255;

figure(2);
subplot(1, 2, 1);imshow(imagemAdulterada);title('Imagem Adulterada');
subplot(1, 2, 2);imshow(mensagemAdulterada);title('Mensagem Extraída (Adulterada)');