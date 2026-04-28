#include <Arduino.h>

// put function declarations here:
#define VER_1 12
#define AMAR_1 11
#define VERD_1 10
#define VER_2 9
#define AMAR_2 8
#define VERD_2 7
#define CINCO 5000
#define DOIS 2000

void setup() {
  Serial.begin(57600);
  Serial.println("Bem-vindo ao Semáforo inteligente");
  pinMode(VER_1, OUTPUT);
  pinMode(AMAR_1, OUTPUT);
  pinMode(VERD_1, OUTPUT);
  pinMode(VER_2, OUTPUT);
  pinMode(AMAR_2, OUTPUT);
  pinMode(VERD_2, OUTPUT);
}
void loop() {
  digitalWrite(VER_1, HIGH);
  digitalWrite(VERD_2, HIGH);
  Serial.println("ATENÇÃO! Rua A está fechada e a Rua B está aberta");
  delay(CINCO);
  digitalWrite(VER_1, LOW);
  digitalWrite(VERD_2, LOW);

  digitalWrite(AMAR_1, HIGH);
  digitalWrite(AMAR_2, HIGH);
  Serial.println("PERA! Rua A vai abrir e a Rua B vai fechar");
  delay(DOIS);
  digitalWrite(AMAR_1, LOW);
  digitalWrite(AMAR_2, LOW);

  digitalWrite(VERD_1, HIGH);
  digitalWrite(VER_2, HIGH);
  Serial.println("ATENÇÃO! Rua A está aberta e a Rua B está fechada");
  delay(CINCO);
  digitalWrite(VERD_1, LOW);
  digitalWrite(VER_2, LOW);
}
