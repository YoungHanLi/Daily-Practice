byte patterns[] = {0xFC, 0x60, 0xDA, 0xF2, 0x66, 0xB6, 0xBE, 0xE4, 0xFE, 0xE6};
int digit_select_pin[] = {66,67,68,69};
int segment_pin[] = {58,59,60,61,62,63,64,65};

void show_digit(int pos, int number);

void setup() {
  for(int i=0; i<4; i++){
    pinMode(digit_select_pin[i], OUTPUT);
  }
  for(int i=0; i<8; i++){
    pinMode(segment_pin[i], OUTPUT);
  }
}

void loop() {
  for(int no=0; no<10; no++){
    for(int pos=1; pos<=4; pos++){
      show_digit(pos, no);
      delay(200);
    }
  }
}

void show_digit(int pos, int number){
  for(int i=0; i<4; i++){
    if(i+1 == pos) //common cathode 공통음극
      digitalWrite(digit_select_pin[i], LOW); 
    else
      digitalWrite(digit_select_pin[i], HIGH);
  }
  for(int i=0; i<8; i++){
    digitalWrite(segment_pin[i],  bitRead(patterns[number], 7-i));
  }
}
