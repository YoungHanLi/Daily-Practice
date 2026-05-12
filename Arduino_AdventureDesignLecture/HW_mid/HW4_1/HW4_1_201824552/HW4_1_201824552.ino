//HW4_1
//201824552

const int LENGTH = 5;
char CharBuffer[100];
int len;
String str[LENGTH];

void setup() {
  Serial.begin(9600);
}

void loop() {

  
//input Words
  for(int i=0; i<LENGTH; i++){
    Serial.print(String("Enter the ") + i + String("th Word -->"));
    
    while(!(Serial.available())) {;} // stopped until enter anythings
    
    len = Serial.readBytesUntil('\n', CharBuffer, 100);
    CharBuffer[len]='\0';
    str[i] = String(CharBuffer);

    Serial.println(str[i]);
  }

//Sorting
  for(int i=0; i<LENGTH-1; i++){
    for(int j=i+1; j<LENGTH; j++){
      if(str[i].compareTo(str[j]) > 0){
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
      }
    }
  }

  
//print Sorted Words
  Serial.println("After Sorting");
  for(int i=0; i<LENGTH; i++){
    Serial.println(str[i]);
  }

  
}
