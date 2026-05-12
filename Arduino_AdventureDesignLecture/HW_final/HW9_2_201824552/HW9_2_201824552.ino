int Enable1 = 38;
int PWM1 = 9;
int DIR1 = 39;

int button_pin = 14;
boolean previous_button_state = false;
boolean current_button_state;
int state[] = {255, 127, 0};
int i=0;

void setup() {
  pinMode(Enable1, OUTPUT);
  pinMode(PWM1, OUTPUT);
  pinMode(DIR1, OUTPUT);

  digitalWrite(Enable1, HIGH);
  digitalWrite(DIR1, HIGH);
  digitalWrite(PWM1, HIGH);

  pinMode(button_pin, INPUT);
}

void loop() {
  if(!(current_button_state = digitalRead(button_pin)))
    previous_button_state = false;
  if(current_button_state == true && previous_button_state == false){
    previous_button_state = true;
    i = (i+1)%3;
  }
  analogWrite(PWM1, state[i]);
  delay(100);
}
