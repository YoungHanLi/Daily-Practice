int pin_LED1 = 2;
int pin_LED2 = 13;
boolean LED_state1 = false;
boolean LED_state2 = false;
unsigned long time_previous1, time_previous2;
unsigned long time_current;
int interval1;
int interval2;

void setup() {
  pinMode(A0, INPUT);

  pinMode(pin_LED1, OUTPUT);
  digitalWrite(pin_LED1, LED_state1);
  pinMode(pin_LED2, OUTPUT);
  digitalWrite(pin_LED2, LED_state2);
  Serial.begin(9600);
  time_previous1 = millis();
  time_previous2 = millis();
}

void loop() {
  time_current = millis();

  int adc = analogRead(A0);
  interval1 = map(adc, 0, 1023, 1500, 500);
  interval2 = map(adc, 0, 1023, 500, 1500);

  Serial.println(interval2);
  
  if(time_current - time_previous1 >= interval1){
    time_previous1 = time_current;

    LED_state1 = !LED_state1;
    digitalWrite(pin_LED1, LED_state1);
  }

  if(time_current - time_previous2 >= interval2){
    time_previous2 = time_current;

    LED_state2 = !LED_state2;
    digitalWrite(pin_LED2, LED_state2);
  }

}
