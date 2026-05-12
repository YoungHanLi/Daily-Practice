#include <Wire.h>
#include <ADXL345.h>

ADXL345 adxl;
int ledpin = 2;
boolean previous_state = false;
boolean current_state;
boolean led_state = false;
boolean flag = false;

unsigned long current_time;
unsigned long previous_time;

int toggle_count = 0;
int shake_count = 0;

void setup(){
  Serial.begin(9600);
  adxl.powerOn();
  pinMode(ledpin, OUTPUT);
  digitalWrite(ledpin, previous_state);
  previous_time = millis();
  
  //set activity/ inactivity thresholds (0-255)
  adxl.setActivityThreshold(75); //62.5mg per increment
  adxl.setInactivityThreshold(75); //62.5mg per increment
  adxl.setTimeInactivity(10); // how many seconds of no activity is inactive?
 
  //look of activity movement on this axes - 1 == on; 0 == off 
  adxl.setActivityX(1);
  adxl.setActivityY(1);
  adxl.setActivityZ(1);
 
  //look of inactivity movement on this axes - 1 == on; 0 == off
  adxl.setInactivityX(1);
  adxl.setInactivityY(1);
  adxl.setInactivityZ(1);
 
  //look of tap movement on this axes - 1 == on; 0 == off
  adxl.setTapDetectionOnX(0);
  adxl.setTapDetectionOnY(0);
  adxl.setTapDetectionOnZ(1);
 
  //set values for what is a tap, and what is a double tap (0-255)
  adxl.setTapThreshold(50); //62.5mg per increment
  adxl.setTapDuration(15); //625us per increment
  adxl.setDoubleTapLatency(80); //1.25ms per increment
  adxl.setDoubleTapWindow(200); //1.25ms per increment
 
  //set values for what is considered freefall (0-255)
  adxl.setFreeFallThreshold(7); //(5 - 9) recommended - 62.5mg per increment
  adxl.setFreeFallDuration(45); //(20 - 70) recommended - 5ms per increment
 
  //setting all interrupts to take place on int pin 1
  //I had issues with int pin 2, was unable to reset it
  adxl.setInterruptMapping( ADXL345_INT_SINGLE_TAP_BIT,   ADXL345_INT1_PIN );
  adxl.setInterruptMapping( ADXL345_INT_DOUBLE_TAP_BIT,   ADXL345_INT1_PIN );
  adxl.setInterruptMapping( ADXL345_INT_FREE_FALL_BIT,    ADXL345_INT1_PIN );
  adxl.setInterruptMapping( ADXL345_INT_ACTIVITY_BIT,     ADXL345_INT1_PIN );
  adxl.setInterruptMapping( ADXL345_INT_INACTIVITY_BIT,   ADXL345_INT1_PIN );
 
  //register interrupt actions - 1 == on; 0 == off  
  adxl.setInterrupt( ADXL345_INT_SINGLE_TAP_BIT, 1);
  adxl.setInterrupt( ADXL345_INT_DOUBLE_TAP_BIT, 1);
  adxl.setInterrupt( ADXL345_INT_FREE_FALL_BIT,  1);
  adxl.setInterrupt( ADXL345_INT_ACTIVITY_BIT,   1);
  adxl.setInterrupt( ADXL345_INT_INACTIVITY_BIT, 1);
}

void loop(){
  byte interrupts = adxl.getInterruptSource();
  current_time = millis();
  while(current_time - previous_time < 2000){
    current_time = millis();
    if(adxl.triggered(interrupts, ADXL345_ACTIVITY)){
      current_state = true;
      //Serial.println("ACTIVE");
      flag = true;
      break;
    }
    else
      flag = false;
  }
  previous_time = current_time;
  if(flag == false){
    //Serial.println("*******INACTIVE*******");
    current_state = false;
    previous_state = false;
  }
  if(current_state == true){
    if(previous_state == false){
      led_state = !led_state;
      digitalWrite(ledpin, led_state);
      delay(50);
      previous_state = true;
      shake_count++;
      toggle_count = shake_count/2;
      if(shake_count%2 == 0){
        Serial.print("Toggled : ");
        Serial.println(toggle_count);
      }
    }
  }

}
