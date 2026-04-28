#include <Arduino.h>                                                                                                                      

/**
IFSP - INSTITUTO FEDERAL DE EDUC., CIÊNCIA E TECNOLOGIA DE SÃO PAULO - Brazil
Prof. Osvandre Martins - osvandre@ifsp.edu.br - OUT/2023  

Demo#03 - Leitura de Botao
Detecção de evento de botão, sem interrupção.
*/

#define BTN_PIN 2

int count;  //Contador
int btnState; //Controla o estado atual do botão
int lastState; //Controla o último estado para evitar bounce 
int ledState; //Controla o estado do LED
int LED = 4;

void setup() {
  // put your setup code here, to run once:
  pinMode(BTN_PIN, INPUT_PULLUP); //Uso de resistor interno da Arduino. Em circuito tem que usar um resistor de 10k Ohms 
  Serial.begin(57600);
  Serial.println(">>>>> DETECTANDO BOTÃO <<<<<");
  count = 0;
  lastState = LOW;
  pinMode(LED, OUTPUT);

}

void loop() {

  btnState = digitalRead(BTN_PIN); //Lê sinal no pino de leitura do botão
  ledState = digitalRead(LED);

  if (btnState == HIGH && lastState == LOW) {
    if(ledState == LOW){
      digitalWrite(LED, HIGH);
    } else {
      digitalWrite(LED, LOW);
    }
    lastState = HIGH;
    count++;
    Serial.println(count);
  }

  if (btnState == LOW && lastState == HIGH) {
    lastState = LOW;
  }

}