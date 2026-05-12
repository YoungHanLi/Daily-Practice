int pin[]={2, 3, 4, 5};
int state=0;

void setup() {
  Serial.begin(9600);
  for(int i=0; i<4; i++){
    pinMode(pin[i], OUTPUT);
    digitalWrite(pin[i], LOW);  
  }

}

void loop() {
  for(int i=0; i<4; i++){
    if(i==state){
      Serial.print("O ");
      digitalWrite(pin[i], HIGH);
    }
    else{
      Serial.print("X ");
      digitalWrite(pin[i], LOW);
    }
  }
  Serial.println();
  state = (state+1)%4;
  delay(1000);
  
}
