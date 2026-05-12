int pins_LED[]={2, 3, 4, 5};
const int LED_MAX = 255;
int LED_0_MIN = LED_MAX * 0 / 4;
int LED_1_MIN = LED_MAX * 1 / 4;
int LED_2_MIN = LED_MAX * 2 / 4;
int LED_3_MIN = LED_MAX * 3 / 4;
unsigned long j = 0;
int n0, n1, n2, n3;

void setup() {
  Serial.begin(9600);

  for(int i=0; i<4; i++)
    pinMode(pins_LED[i], OUTPUT);
}

void loop() {
  
  int i=0;

  n0 = (LED_0_MIN + j) % (LED_MAX + 1);
  n1 = (LED_1_MIN + j) % (LED_MAX + 1);
  n2 = (LED_2_MIN + j) % (LED_MAX + 1);
  n3 = (LED_3_MIN + j) % (LED_MAX + 1);

  analogWrite(pins_LED[i++], n0);
  delay(8);
  analogWrite(pins_LED[i++], n1);
  delay(8);
  analogWrite(pins_LED[i++], n2);
  delay(8);
  analogWrite(pins_LED[i++], n3);
  delay(8);

  j++;
  
}
