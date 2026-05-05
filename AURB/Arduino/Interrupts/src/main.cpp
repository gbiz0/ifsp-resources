#include <Arduino.h>

#define BUTTON_PIN 2
#define LED_STATUS 3

volatile bool shouldMoveMotor = false;
volatile unsigned long lastInterruptTime = 0;
const unsigned long debounceTime = 200;

int contadorPressionamentos = 0;

void triggerMoveMotor();
void moveMotor();

void setup() {
  Serial.begin(9600);
  pinMode(BUTTON_PIN, INPUT_PULLUP);
  pinMode(LED_STATUS, OUTPUT);
  attachInterrupt(digitalPinToInterrupt(BUTTON_PIN), triggerMoveMotor, RISING);
}

void loop() {
  if (shouldMoveMotor) {
    contadorPressionamentos++;
    Serial.print("Vezes pressionado: ");
    Serial.println(contadorPressionamentos);
    
    moveMotor();
    shouldMoveMotor = false;
  }
}

void triggerMoveMotor() {
  unsigned long interruptTime = millis();
  if (interruptTime - lastInterruptTime > debounceTime) {
    shouldMoveMotor = true;
    lastInterruptTime = interruptTime;
  }
}

void moveMotor() {
  if (digitalRead(LED_STATUS) == LOW) {
    digitalWrite(LED_STATUS, HIGH);
    delay(1000);
    digitalWrite(LED_STATUS, LOW);
  }
}