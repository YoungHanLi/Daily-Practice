#include <Servo.h>

Servo myServo;
int servoPin = 11;
String buffer = "";
boolean process_it = false;

void setup() {
  myServo.attach(servoPin);
  Serial.begin(9600);
}

void loop() {
  while(Serial.available()){
    char data = Serial.read();
    if(data == '\n'){
      process_it = true;
      break;
    }
    buffer += data;
  }

  if(process_it){
    process_it = false;
    int angle = buffer.toInt();
    Serial.print(String(">> ") + buffer);

    if(angle<0 || angle>180){
      Serial.println(" ... invalid angle.");
    }
    else{
      Serial.println();
      myServo.write(angle);
      delay(3);
    }
    buffer = "";
  }
}
