int vResistor = A0;

void setup() {
  Serial.begin(9600);
  pinMode(vResistor, INPUT);
  //analogReference(INTERNAL1V1);
  //analogReference(INTERNAL2V56);
}

void loop() {
  Serial.println(analogRead(vResistor));
  delay(1000);
}
