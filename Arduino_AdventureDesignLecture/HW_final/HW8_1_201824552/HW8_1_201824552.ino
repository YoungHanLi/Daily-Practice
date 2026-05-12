byte patterns[] = {0xFC, 0x60, 0xDA, 0xF2, 0x66, 0xB6, 0xBE, 0xE4, 0xFE, 0xE6};
int digit_select_pin[] = {66,67,68};
int segment_pin[] = {58,59,60,61,62,63,64,65};
int button_pin = 14;

boolean previous_button_state = false;
boolean current_button_state;
boolean decrease = false;
int count=0;
int SEGMENT_DELAY=5;
unsigned long time_previous, time_current;

void show_digit(int pos, int number);
void show_3_digit(int number);

void setup() {
  pinMode(button_pin, INPUT_PULLUP);
  for(int i=0; i<3; i++){
    pinMode(digit_select_pin[i], OUTPUT);
  }
  for(int i=0; i<8; i++){
    pinMode(segment_pin[i], OUTPUT);
  }
  time_previous = millis();
}

void loop() {
  time_current = millis();
  current_button_state = digitalRead(button_pin);
  if(current_button_state == false)
    previous_button_state = false;
  
  if(current_button_state == true && previous_button_state == false){
    previous_button_state = true;
    decrease = !(decrease);
    delay(50);
  }

  if(time_current - time_previous >= 1000){
    time_previous = time_current;

    if(decrease == false)
      count++;
    else
      count--;
  }

  if(count == 1000)
    count=0;
  else if(count == -1)
    count=999;
  
  show_3_digit(count);
}

void show_digit(int pos, int number){
  for(int i=0; i<3; i++){
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

void show_3_digit(int number){
  number %= 1000;
  int hundreads = number / 100;
  number %= 100;
  int tens = number / 10;
  int ones = number % 10;

  show_digit(1, hundreads);
  delay(SEGMENT_DELAY);
  show_digit(2, tens);
  delay(SEGMENT_DELAY);
  show_digit(3, ones);
  delay(SEGMENT_DELAY);
}
