// 온도센서 A1;
// 조도센서 A2;
void readTemperature();
void readIllumiance();

void setup() {
  Serial.begin(9600);
}

void loop() {
  readTemperature();
  readIllumiance();
  delay(1000);
}

void readTemperature(){
  
  // Convert Return-value of ADC to Voltage 
  float voltage = (float)analogRead(A1) * 5.0 / 1024.0;
  Serial.print(voltage);
  Serial.print(" V : ");

  // C temp
  float temp_C = voltage * 100.0;
  Serial.print(temp_C);
  Serial.print(" C, ");
  
  // F temp
  float temp_F = (temp_C * 9.0 / 5.0) + 32.0;
  Serial.print(temp_F);
  Serial.println(" F");
}

void readIllumiance(){

  int reading = analogRead(A2);
  Serial.print("ADC : ");
  Serial.print(reading);

  // Convert Return-value of ADC to Voltage
  float voltage = reading * 5.0 / 1024.0;
  Serial.print(", Voltage : ");
  Serial.println(voltage);
}
