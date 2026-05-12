#include<LiquidCrystal.h>

LiquidCrystal lcd(44,45,46,47,48,49);

void setup() {
  lcd.begin(16,2);
  lcd.print("Hello World");
}

void loop() {

}
