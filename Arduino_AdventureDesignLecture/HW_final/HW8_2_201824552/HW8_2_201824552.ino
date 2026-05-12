#include <LiquidCrystal.h>

LiquidCrystal lcd(44,45,46,47,48,49);
int pinTemp = A1;
int pinLight = A2;
float temp, light;

byte user1[] = {
  B00000,
  B10000,
  B00110,
  B01001,
  B10000,
  B01001,
  B00110,
  B00000
};

void setup() {
  pinMode(pinTemp, INPUT);
  pinMode(pinLight, INPUT);
  lcd.begin(16,2);

  lcd.createChar(0, user1);
}

void loop() {
  temp = (analogRead(pinTemp)*5.0/1024.0)*100.0;
  lcd.setCursor(0,0);
  lcd.print("Temp: ");
  lcd.print(temp);
  lcd.write(byte(0));

  light = (1023.0 - analogRead(pinLight))/1023.0;
  lcd.setCursor(0,1);
  lcd.print("Light: ");
  lcd.print(light);

  delay(1000);
}
