//가변저항
byte patterns[] = {0xFC, 0x60, 0xDA, 0xF2, 0x66, 0xB6, 0xBE, 0xE4, 0xFE, 0xE6};
int digit_select_pin[] = {66,67,68,69};
int segment_pin[] = {58,59,60,61,62,63,64,65};
int SEGMENT_DELAY=5;

void show_digit(int pos, int number);
void show_4_digit(int number);


void setup() {
  for(int i=0; i<4; i++){
    pinMode(digit_select_pin[i], OUTPUT);
  }
  for(int i=0; i<8; i++){
    pinMode(segment_pin[i], OUTPUT);
  }
}

void loop() {
 int reading = analogRead(A0);
 show_4_digit(reading);
}

void show_digit(int pos, int number){
  for(int i=0; i<4; i++){
    if(i+1 == pos)
      digitalWrite(digit_select_pin[i], LOW);
    else
      digitalWrite(digit_select_pin[i], HIGH);
  }
  for(int i=0; i<8; i++){
    boolean on_off = bitRead(patterns[number], 7-i);
    digitalWrite(segment_pin[i], on_off);
  }
}

void show_4_digit(int number){
  number %= 10000;
  int thousands = number / 1000;
  number %= 1000;
  int hundreads = number / 100;
  number %= 100;
  int tens = number / 10;
  int ones = number % 10;

  show_digit(1, thousands);
  delay(SEGMENT_DELAY);
  show_digit(2, hundreads);
  delay(SEGMENT_DELAY);
  show_digit(3, tens);
  delay(SEGMENT_DELAY);
  show_digit(4, ones);
  delay(SEGMENT_DELAY);
}
