#include <Arduino.h>
#include <LiquidCrystal_I2C.h> 

#define PIN_RED 5
const float GAMMA = 0.7;
const float RL10 = 50;

LiquidCrystal_I2C lcd(0x27, 16, 2); 

void setup() {
  pinMode(PIN_RED, OUTPUT);
  lcd.init();
  lcd.backlight();
  
  lcd.setCursor(0, 0);
  lcd.print("Auto Light ON");
  delay(1000);
  lcd.clear();
}

void loop() {
  int analogValue = analogRead(A0); 
  
  float voltage = analogValue / 1024.0 * 5;
  float resistance = 2000 * voltage / (1 - voltage / 5);
  float lux = pow(RL10 * 1e3 * pow(10, GAMMA) / resistance, (1 / GAMMA));

  int pwmVal = 200 / lux;
  analogWrite(PIN_RED, pwmVal);
  


  lcd.setCursor(0, 0);
  lcd.print("Lux: ");
  lcd.print(lux);
  lcd.print("          "); 

  lcd.setCursor(0, 1);
  lcd.print("LED: ");
  lcd.print(pwmVal); 
  lcd.print("%   ");

  delay(100); 
}