int RGB_LED[]={6, 7, 8};

void setup() {
  for(int i=0; i<sizeof(RGB_LED)/sizeof(int); i++)
    pinMode(RGB_LED[i], OUTPUT);
}

void loop() {
  //Blue color control, OFF : Green, Red
  digitalWrite(RGB_LED[1], LOW); //Green
  digitalWrite(RGB_LED[2], LOW); //Red
  for(int i=0; i<256; i++){
    analogWrite(RGB_LED[0], i);
    delay(10);
  }

  //Green color control, OFF : Blue, Red
  digitalWrite(RGB_LED[0], LOW); //Blue
  digitalWrite(RGB_LED[2], LOW); //Red
  for(int i=0; i<256; i++){
    analogWrite(RGB_LED[1], i);
    delay(10);
  }

  //Red color control, OFF : Blue, Green
  digitalWrite(RGB_LED[0], LOW);
  digitalWrite(RGB_LED[1], LOW);
  for(int i=0; i<256; i++){
    analogWrite(RGB_LED[2], i);
    delay(10);
  }
}
