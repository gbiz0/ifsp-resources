#include <Arduino.h>

#define BTN_PIN 2
#define LED_PIN 3

volatile int count;  //Contador de ascio
volatile bool ledState; //Para controle se o LED deve estar ligado ou não.
volatile unsigned long currentMillis; //Registra a momento de ocorrência da interrupção

void doTheJob();
void showMoment();

void setup() {
  pinMode(LED_PIN, OUTPUT);
  //Uso de resistor interno da Arduino. Em circuito tem que usar um resistor de 10k Ohms   
  pinMode(BTN_PIN, INPUT_PULLUP); 
  /* Chama a rotina de interupção (ISR) sempre que um evento de interrupção FALLING for detectado no pino 2*/
  attachInterrupt(digitalPinToInterrupt(2), doTheJob, FALLING); 
  Serial.begin(57600);
  Serial.println(">>>>> DETECTANDO BOTÃO POR INTERRUPÇÃO <<<<<");
  count = 0;    
}


void loop() {
  //Na a fazer aqui!!!   A ISR agirá quando o evento ocorrer!
}



/** 
 Função para execução mediante interrupção
 Realiza um certo trabalho quando a interrupção ocorre. 
 Esse trabalho comumente é de ajuste de variáveis de controle.
 */
void doTheJob() {
  count++; //Incrementa o contador de acionamentos. Só por curiosidade! ;-)
  Serial.print(count);
  showMoment();
  ledState = !ledState; //HIGH (1) -> LOW (0) ou LOW (0) -> HIGH (1)
  digitalWrite(LED_PIN, ledState); //Aciona LED conforme a alteração do estado do LED na ISR
}



/**
Mostra o momento de ocorrência da interrupção (botão pressionado) e exibe em formato HH:MM:SS
**/
void showMoment() {
  currentMillis = millis();
  unsigned long seconds = currentMillis / 1000;
  unsigned long minutes = seconds / 60;
  unsigned long hours = minutes / 60;
  unsigned long days = hours / 24;
  currentMillis %= 1000;
  seconds %= 60;
  minutes %= 60;
  hours %= 24;

  Serial.print(" momento: ");
  Serial.print(hours);
  Serial.print(':');
  if (minutes < 10)
    Serial.print('0');
  Serial.print(minutes);
  Serial.print(':');
  if (seconds < 10)
    Serial.print('0');
  Serial.print(seconds);
  Serial.print('.');
  if (currentMillis < 100)
    Serial.print('0');
  if (currentMillis < 10)
    Serial.print('0');
  Serial.println(currentMillis);
}
