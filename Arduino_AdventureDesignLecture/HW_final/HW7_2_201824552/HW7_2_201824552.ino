#include <pitches.h>
int potentiometerPin = A2;
int speakerPin = 2;
int melody[] = {
  0, NOTE_C4, NOTE_D4, NOTE_E4, NOTE_F4,
  NOTE_G4, NOTE_A4, NOTE_B4, NOTE_C5
};
int noteLength = 1000/4;

void setup() {
  Serial.begin(9600);
  pinMode(speakerPin, INPUT);
}

void loop() {
  //가변저항 input
  int analogInput = analogRead(potentiometerPin);

  //평등하게 9등분
  int outNote = (int)map(analogInput,0,1023,0,9);
  if(outNote == 9) // when analogInput == 1023
    outNote = 8;
  Serial.println(outNote);
  
  //소리출력
  tone(speakerPin, melody[outNote], noteLength);  
}
