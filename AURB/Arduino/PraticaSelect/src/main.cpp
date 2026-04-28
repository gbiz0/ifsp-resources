#include <Arduino.h>

#define GREEN_PIN 10
#define YELLOW_PIN 11
#define RED_PIN 12
#define TIMEOUT 3000

void setup() {
  Serial.begin(5600);
  Serial.println("Selecione a cor que deseja acender: (V)erde, (A)marelo, (R)vermelho");

  pinMode(GREEN_PIN, OUTPUT);
  pinMode(YELLOW_PIN, OUTPUT);
  pinMode(RED_PIN, OUTPUT);
}

void loop() {
  if (Serial.available() > 0) {
    
    char LED_INPUT = Serial.read();

    switch (LED_INPUT) {
      case 'v':
      case 'V':
        digitalWrite(GREEN_PIN, HIGH);
        digitalWrite(YELLOW_PIN, LOW);
        digitalWrite(RED_PIN, LOW);
        Serial.println("LED Verde ligado");
        delay(TIMEOUT);
        digitalWrite(GREEN_PIN, LOW);
        Serial.println("LED Verde desligado");
        break;
        
      case 'a':
      case 'A':
        digitalWrite(GREEN_PIN, LOW);
        digitalWrite(YELLOW_PIN, HIGH);
        digitalWrite(RED_PIN, LOW);
        Serial.println("LED Amarelo ligado");
        delay(TIMEOUT);
        digitalWrite(YELLOW_PIN, LOW);
        Serial.println("LED Amarelo desligado");
        break;
        
      case 'r':
      case 'R':
        digitalWrite(GREEN_PIN, LOW);
        digitalWrite(YELLOW_PIN, LOW);
        digitalWrite(RED_PIN, HIGH);
        Serial.println("LED Vermelho ligado");
        delay(TIMEOUT);
        digitalWrite(RED_PIN, LOW);
        Serial.println("LED Vermelho desligado");
        break;
        
      default:
        break;
    }
  }
}
