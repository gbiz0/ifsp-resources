#include <Arduino.h>
#include <DHT.h>


/** CONSTANTES **/
#define DHTPIN 8     // Pino digital para leitura do DHT22
#define DHTTYPE DHT22   // DHT 22  (AM2302) - Esta biblioteca funciona com outgras variações do DHT (DHT11)
#define PIN_RED 11
#define PIN_YELLOW 9
#define PIN_GREEN_TEMP 12
#define PIN_GREEN_HUM 10


/** VARIÁVEIS **/
DHT dht(DHTPIN, DHTTYPE); //Inicializa objeto DHT para Arduino em 16mhz
float hum;  //Armazena valor de humidade
float temp; //Armazedna valor de temperatura
float MAX_TEMP = 24.0;
float MIN_HUMIDITY = 40.0;


/** PROTÓTIPOS DE FUNÇÕES **/



/** CONFIGURAÇÃO INICIAL DO DISPSITIVO DE CONTROLE DE AUTOMAÇÃO **/
void setup()
{
  Serial.begin(9600); //Inicializa comunicação Serial para enviar e receber dados na console
	dht.begin(); //Inicializa Sensor DHT22
  pinMode(PIN_RED, OUTPUT);
  pinMode(PIN_YELLOW, OUTPUT);
  pinMode(PIN_GREEN_TEMP, OUTPUT);
  pinMode(PIN_GREEN_HUM, OUTPUT);
}

/** ROTINA CÍCLICA - A FREQUÊNCIA DEPENDE DO TRABALHO QUE ELA EXECUTA */
void loop()
{
    //Realiza leitura de temperatura e umidade guardando nas variáveis para uso posterior
    hum = dht.readHumidity();
    temp= dht.readTemperature();
    //Exibe os valores das variáveis na console.
    if (MAX_TEMP < temp) {
      digitalWrite(PIN_RED, HIGH);
      digitalWrite(PIN_GREEN_TEMP, LOW);
    } else {
      digitalWrite(PIN_RED, LOW);
      digitalWrite(PIN_GREEN_TEMP, HIGH);
    }

    if (MIN_HUMIDITY > hum) {
      digitalWrite(PIN_YELLOW, HIGH);
      digitalWrite(PIN_GREEN_HUM, LOW);
    } else {
      digitalWrite(PIN_YELLOW, LOW);
      digitalWrite(PIN_GREEN_HUM, HIGH);
    }
    
    Serial.print("Umid: ");
    Serial.print(hum);
    Serial.print("%, Temp: ");
    Serial.print(temp);
    Serial.println(" Celsius");
    delay(2000); //Delay 2 seg.
}
