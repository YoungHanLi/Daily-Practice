int button=21;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(button, INPUT_PULLUP);
}

void loop() {
  Serial.println(digitalRead(button));
  delay(1000);
}
