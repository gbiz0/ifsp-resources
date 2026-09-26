clc;
clear;

lenaRGB = imread("lenaRGB.png");

imgR = lenaRGB(:, :, 1);
imgG = lenaRGB(:, :, 2);
imgB = lenaRGB(:, :, 3);

msg1 = imread("MSG1.bmp");
msg2 = imread("MSG2.bmp");
msg3 = imread("MSG3.bmp");

imgRMsg = imgR;
imgGMsg = imgG;
imgBMsg = imgB;

[M, N] = size(imgR);

for i = 1:M
    for j = 1:N
        imgRMsg(i, j) = bitset(imgRMsg(i,j), 1, msg1(i,j));
        imgGMsg(i, j) = bitset(imgGMsg(i,j), 1, msg2(i,j));
        imgBMsg(i, j) = bitset(imgBMsg(i,j), 1, msg3(i,j));
    end
end


imgComMsgR = cat(3, imgRMsg, imgG, imgB);
imgComMsgG = cat(3, imgR, imgGMsg, imgB);
imgComMsgB = cat(3, imgR, imgG, imgBMsg);

marcadaRGB = cat(3, imgRMsg, imgGMsg, imgBMsg);

imwrite(marcadaRGB, 'marcadaRGB.bmp');

figure(1);
subplot(3, 3, 2), imshow(lenaRGB), title('Imagem Original');
subplot(3, 3, 4), imshow(imgComMsgR), title('Banda R com mensagem escondida');
subplot(3, 3, 5), imshow(imgComMsgG), title('Banda G com mensagem escondida');
subplot(3, 3, 6), imshow(imgComMsgB), title('Banda B com mensagem escondida');
subplot(3, 3, 8), imshow(marcadaRGB), title('Imagem RGB com 3 mensagens escondidas');

marcadaRGB = imread("marcadaRGB.bmp");

imgMsg = imread('marcadaRGB.bmp');
imgMsgR = imgMsg(:, :, 1);
imgMsgG = imgMsg(:, :, 2);
imgMsgB = imgMsg(:, :, 3);
[M, N] = size(imgMsgR);

mensagemR = zeros(M,N);
mensagemG = zeros(M,N);
mensagemB = zeros(M,N);

for i=1:M
    for j=1:N
        mensagemR(i,j)=bitget(imgMsgR(i,j),1);
        mensagemG(i,j)=bitget(imgMsgG(i,j),1);
        mensagemB(i,j)=bitget(imgMsgB(i,j),1);
    end
end

figure(2)
subplot(2,2,1);imshow(marcadaRGB), title('Imagem com 3 mensagens escondidas')
subplot(2,2,2);imshow(mensagemR), title('Mensagem Escondida 1 na banda R')
subplot(2,2,3);imshow(mensagemG), title('Mensagem Escondida 2 na banda G')
subplot(2,2,4);imshow(mensagemB), title('Mensagem Escondida 3 na banda B');