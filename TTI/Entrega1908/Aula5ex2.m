clear;
clc;

img = imread("lenaRGB.png");
message1 = imread("Mensagem1RGB.bmp");
message2 = imread("Mensagem2RGB.bmp");
message3 = imread("Mensagem3RGB.bmp");

imgR = img(:,:,1);
imgG = img(:,:,2);
imgB = img(:,:,3);

[m, n] = size(imgR);

imgR_marcado = imgR;
imgG_marcado = imgG;
imgB_marcado = imgB;

for i = 1:m
    for j = 1:n
        imgR_marcado(i,j) = bitset(imgR(i,j), 1, message1(i,j)); 
        imgG_marcado(i,j) = bitset(imgG(i,j), 1, message2(i,j)); 
        imgB_marcado(i,j) = bitset(imgB(i,j), 1, message3(i,j)); 
    end
end

imagemMarcada = cat(3, imgR_marcado, imgG_marcado, imgB_marcado);
imwrite(imagemMarcada, '/Results/markRGB.bmp');

imgMarcadaR = imagemMarcada(:,:,1);
imgMarcadaG = imagemMarcada(:,:,2);
imgMarcadaB = imagemMarcada(:,:,3);

messageExtraida1 = zeros(m, n);
messageExtraida2 = zeros(m, n);
messageExtraida3 = zeros(m, n);

for i = 1:m
    for j = 1:n
        messageExtraida1(i,j) = bitget(imgMarcadaR(i,j), 1);
        messageExtraida2(i,j) = bitget(imgMarcadaG(i,j), 1);
        messageExtraida3(i,j) = bitget(imgMarcadaB(i,j), 1);
    end
end

messageExtraida1 = messageExtraida1 * 255;
messageExtraida2 = messageExtraida2 * 255;
messageExtraida3 = messageExtraida3 * 255;

imagemAdulterada = imagemMarcada;

for i = 50:150
    for j = 50:150
        imagemAdulterada(i,j,:) = 0;
    end
end

imgAdulteradaR = imagemAdulterada(:,:,1);
imgAdulteradaG = imagemAdulterada(:,:,2);
imgAdulteradaB = imagemAdulterada(:,:,3);

msgAdulterada1 = zeros(m, n);
msgAdulterada2 = zeros(m, n);
msgAdulterada3 = zeros(m, n);

for i = 1:m
    for j = 1:n
        msgAdulterada1(i,j) = bitget(imgAdulteradaR(i,j), 1);
        msgAdulterada2(i,j) = bitget(imgAdulteradaG(i,j), 1);
        msgAdulterada3(i,j) = bitget(imgAdulteradaB(i,j), 1);
    end
end

msgAdulterada1 = msgAdulterada1 * 255;
msgAdulterada2 = msgAdulterada2 * 255;
msgAdulterada3 = msgAdulterada3 * 255;

figure(1);
subplot(2, 2, 1); imshow(img);title('Imagem Original');
subplot(2, 2, 2); imshow(message1);title('Mensagem 1 Original (R)');
subplot(2, 2, 3); imshow(message2);title('Mensagem 2 Original (G)');
subplot(2, 2, 4); imshow(message3);title('Mensagem 3 Original (B)');

figure(2);
subplot(2, 2, 1); imshow(imagemMarcada);title('Imagem Marcada (3 Bandas)');
subplot(2, 2, 2); imshow(messageExtraida1);title('Mensagem 1 Extraída (R)');
subplot(2, 2, 3); imshow(messageExtraida2);title('Mensagem 2 Extraída (G)');
subplot(2, 2, 4); imshow(messageExtraida3);title('Mensagem 3 Extraída (B)');

figure(3);
subplot(2, 2, 1);imshow(imagemAdulterada);title('Imagem Adulterada');
subplot(2, 2, 2);imshow(msgAdulterada1);title('Msg 1 Extraída (Adulterada)');
subplot(2, 2, 3);imshow(msgAdulterada2);title('Msg 2 Extraída (Adulterada)');
subplot(2, 2, 4);imshow(msgAdulterada3);title('Msg 3 Extraída (Adulterada)');