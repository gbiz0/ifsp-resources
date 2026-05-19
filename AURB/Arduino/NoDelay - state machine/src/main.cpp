#include <Arduino.h>

#include <Servo.h> //Biblioteca que facilita o controle de servos

#define LED_PIN 4  //Pino de energização do LED
#define SRV_PIN 9  //Pino de comando do Servo

#define LED_ST_ON 1   //Estado LED ligado
#define LED_ST_OFF 0  //Estado LED desligado
#define LED_INTERVAL 500 //Intervalo de tempo para estados do LED
#define SRV_MOV_INTERVAL 15 //Intervalo para movimentação do servo
#define SRV_ST_FW 1   //Estado SERVO movendo para frente (FORWARD)
#define SRV_ST_BK 0   //Estado SERVO movendo para trás (BACKWARD)

Servo myservo;  // Cria um objeto servo (myservo) para comandar o servo 
                //...até 12 são possíveis na maioria das placas.

uint8_t pos;    //Valor referente à posição do servo (0..180)
 
uint8_t currLEDState;  //Controla o estado atual do LED
unsigned long lastLEDStateTime; //Registra o momento de transição de estado do LED
uint8_t currSRVState; //Controla o estado atual do Servo indo para posição ou não
unsigned long lastSRVMovTime; //Registra o momento de inicio de movimento para ir para a posição

unsigned long currTime; //Variável para leitura do tempo atual


/** 
 Controla o LED - Pisca-pisca. 
 A lógica interna preza por evitar a retenção de processamento.
 **/
void blinking() {
  /* Verifica instante para possível transição de estado de controle do LED */
  if (currTime > (lastLEDStateTime + LED_INTERVAL) ) { //Se é momento de transitar estado para o LED...  
    if (currLEDState == LED_ST_ON) {  //Se ON vai pra OFF
      digitalWrite(LED_PIN, LOW);     //Desenergiza o LED
      currLEDState = LED_ST_OFF;      
    } else if (currLEDState == LED_ST_OFF) { //Senão, pergunta o contrário pra garantir e se OFF vai pra ON
      digitalWrite(LED_PIN, HIGH);    //Energiza o LED   
      currLEDState = LED_ST_ON;         
    } else {
      Serial.println("Estado de controle do LED inconsistente. Verifique a programação!"); 
    }
    lastLEDStateTime = currTime; //Atualiza instante da mudança de estado    
  }
}


/** 
Controla o Servo - Movimenta para frente e para trás.
 A lógica interna preza por evitar a retenção de processamento.
**/
void moving() {
  if (currTime > (lastSRVMovTime + SRV_MOV_INTERVAL)) { //Só comanda o servo se ele não estiver se movimentando
    myservo.write(pos);  // Posiciona o servo conforme o valor de 'pos'
    lastSRVMovTime = currTime; //Atualiza instante do último comando do servo
    /* Atualiza 'pos' no ciclo corrente, conforme estado de movimento atual do servo (frente ou trás) */
    if (currSRVState == SRV_ST_FW) { //Se movimento à frente...
      if (pos < 180) { //Se ainda não atingiu o limite superior (180)
        pos = pos + 1; //Incrementa 'pos' - Uma das formas de incrementar variável na ling. C. O mesmo que  pos++; ou pos += 1;
      } else { //Se chegou no fim do curso à frente (FORWARD), transita para estado 'voltando' (BACKWARD)
        currSRVState = SRV_ST_BK;
      }
    } else if (currSRVState == SRV_ST_BK) { //Se movimento à trás...
      if (pos > 0) { //Se ainda não atingiu o limite inferior (0)
        pos--; //Decrementa 'pos' - O mesmo que pos = pos - 1 ou pos-- na ling. C
      } else { //Se chegou no fim do curso à trás (BACKWARD), transita para estado 'avançando' (FORWARD)
        currSRVState = SRV_ST_FW;
      }
    } else {
      Serial.println("Estado de controle do Servo inconsistente. Verifique a programação!");
    }
  }
}



void setup() 
{ 
  pinMode(LED_PIN, OUTPUT);     
  myservo.attach(SRV_PIN);  //Conecta ao servo para controlá-lo.
  currLEDState = LED_ST_ON; //Estado inicial para o LED
  currSRVState = SRV_ST_FW; //Estado inicial para o SRV
  lastLEDStateTime = 0; //Momento de transição do estado atual do LED
  lastSRVMovTime = 0; //Momento de início de movimento do servo 
  pos = 0;
  Serial.begin(115200);
  Serial.println(">>>>> IMPLEMENTANDO PSEUDOPARALELISMO COM MÁQUINA DE ESTADOS <<<<<");
} 
 


void loop() { 
  currTime = millis(); //Obtem instante atual
  blinking(); //Chama a função que controla o LED
  moving(); //Chama a função que controla o Servo
} 