#include <Servo.h>

Servo myServo;
int servoPin = 11;
int button[] = {14, 15};
boolean button_state[] = {false, false};
int angle = 0;

void setup() {
  myServo.attach(servoPin);
  for(int i=0; i< sizeof(button)/sizeof(int); i++){
    pinMode(button[i], INPUT);
  }
}

void loop() {
  for(int i=0; i < sizeof(button)/sizeof(int); i++){
    if(digitalRead(button[i]))
        button_state[i] = true; 
  }

  for(int i=0; i < sizeof(button)/sizeof(int); i++){
    if(button_state[i] == true){
      button_state[i] = false;
      if(i == 0 && angle < 180){
        angle += 10;
      }
      else if(i == 1 && angle > 0){
        angle -= 10;
      }
      myServo.write(angle);
      delay(100);
    }
  }
}
