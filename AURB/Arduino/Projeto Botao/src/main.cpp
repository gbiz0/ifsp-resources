#include <Arduino.h>

#define BTN_PIN 2

int count;  //Contador
int btnState; //Controla o estado atual do botão
int lastState; //Controla o último estado para evitar bounce 


void setup() {
  // put your setup code here, to run once:
  pinMode(BTN_PIN, INPUT_PULLUP); //Uso de resistor interno da Arduino. Em circuito tem que usar um resistor de 10k Ohms 
  Serial.begin(57600);
  Serial.println(">>>>> DETECTANDO BOTÃO <<<<<");
  count = 0;
  lastState = LOW;
}

void loop() {

  btnState = digitalRead(BTN_PIN); //Lê sinal no pino de leitura do botão

  if (btnState == HIGH && lastState == LOW) {
    lastState = HIGH;
    count++;
    Serial.println(count);
  }

  if (btnState == LOW && lastState == HIGH) {
    lastState = LOW;
  }

}
