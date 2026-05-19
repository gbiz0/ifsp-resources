#include <Arduino.h>


#define LED_PIN 4


#include <Servo.h> //Biblioteca que facilita o controle de servos
 

Servo myservo;  // Cria um objeto servo (myservo) para comandar o servo 
                //...até 12 são possíveis na maioria das placas.
 
int pos = 0;    //Valor referente à posição do servo (0..180)
 


void setup() 
{ 
  // initialize the digital pin as an output.
  pinMode(LED_PIN, OUTPUT);     
  myservo.attach(9);  // attaches the servo on pin 9 to the servo object 
} 
 
void loop() { 
  /** Controla o LED **/
  digitalWrite(LED_PIN, HIGH);   // Energiza o LED
  delay(1000);               // Espera 1s
  digitalWrite(LED_PIN, LOW);    // Desenergiza o LED
  delay(1000);               // Espera 1s
  
  /** Avança a posição do servo **/
  for(pos = 0; pos <= 180; pos += 1) // Repete para angulos de 0 a 180...
  {                                  // ...em passos de 1 grau, atualizando 'pos'
    myservo.write(pos);              // Comanda o servo conforme valor de 'pos' 
    delay(15);                       // Espera 15ms para o servo alcançar a posição. 
  }                                  // 2.715ms

  /** Retrocede a posição do servo **/
  for(pos = 180; pos>=0; pos-=1)     // Retorna a posição do servo de 180 para 0 ...
  {                                  // ...em passos de 1 grau, atualizando 'pos'
    myservo.write(pos);              // Comanda o servo conforme valor de 'pos'  
    delay(15);                       // Espera 15ms para o servo alcançar a posição.
  }                                  // 2.715ms

} 