//HW2-201824552
void setup() {
 Serial.begin(9600);
 Serial.println("Enter 2 Integers to add");
}

void loop() {
  if(Serial.available()){
    int num1 = Serial.parseInt();
    int num2 = Serial.parseInt();

    Serial.print(num1);
    Serial.print(" + ");
    Serial.print(num2);
    Serial.print(" = ");
    Serial.println(num1+num2);
    Serial.println("Enter 2 Integers to add");
  }
}
