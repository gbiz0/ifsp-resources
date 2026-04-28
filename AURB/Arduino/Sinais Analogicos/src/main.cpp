#include <Arduino.h>

#define LED_PIN 9

void setup() {
  Serial.begin(115200); 
  pinMode(LED_PIN, OUTPUT);
}

void loop() {
  int value = analogRead(A0); //A0 é uma constante pré-definida pela biblioteca da Arduino para o pino analógico 0
  Serial.println(value); //O valor de leitura analógica será de 0 a 1023
  digitalWrite(LED_PIN, HIGH);
  delay(1023 - value);
  digitalWrite(LED_PIN, LOW);
  delay(1023 - value);
}