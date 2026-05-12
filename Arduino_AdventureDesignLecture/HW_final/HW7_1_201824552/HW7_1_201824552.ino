int LED_pins[] = {2, 3, 4, 5};
int num_LED = sizeof(LED_pins)/sizeof(int);

void setup() {
  //pinMode(A2, INPUT); //unnecesarry
  for(int i=0; i<num_LED; i++){
    pinMode(LED_pins[i],OUTPUT);
    digitalWrite(LED_pins[i], LOW);
  }
  Serial.begin(9600);
}

void loop() {
  int val_ADC = analogRead(A2);
  Serial.print(val_ADC);
  int num_ON_LED = (val_ADC>>8) + 1;
  Serial.print('\t');
  Serial.println(num_ON_LED);

  if(val_ADC <= 150){
    for(int i=0; i<num_LED; i++)
      digitalWrite(LED_pins[i], LOW);
  }
  else{
    for(int i=0; i<num_LED; i++){  
      if(i < num_ON_LED)
        digitalWrite(LED_pins[i], HIGH);
      else
        digitalWrite(LED_pins[i], LOW);
    }
  }

  delay(100);
}
