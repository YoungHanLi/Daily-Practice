int pin[]={2, 3, 4, 5};
int pattern=1;
int patternState;

void setup() {
  Serial.begin(9600);
  for(int i=0; i<4; i++){
    pinMode(pin[i], OUTPUT);
    digitalWrite(pin[i], LOW);
  }

}

void loop() {
  for(int i=0; i<4; i++){
    if(i<pattern){
      digitalWrite(pin[i], HIGH);
      Serial.print("O ");
    }
    else{
      digitalWrite(pin[i], LOW);
      Serial.print("X ");
    }
  }
  Serial.println();

  if(pattern==4){
    patternState=0;
    
  }
  
  if(pattern==1){
    patternState=1;
  }

  if(patternState==1){
    pattern++;
  }
  else{
    pattern--;
  }

  delay(1000);
}
