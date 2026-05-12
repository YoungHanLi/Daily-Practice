//HW4_2_201824552

int pin_LED[] = {2, 3, 4, 5};
int pin_button = 14;

boolean previous_state=false; // whether button pressed or not
boolean current_state;

boolean order=true;
// true : forward
// false : reverse

int i=0;

void setup() {
  Serial.begin(9600);
  for(int i=0; i<sizeof(pin_LED)/sizeof(int); i++)
    pinMode(pin_LED[i], OUTPUT);
  pinMode(pin_button, INPUT);
}

void loop() {
  
  //Check whether button pressed down or not
  current_state = digitalRead(pin_button);
  if(current_state){
    if(!(previous_state)){
      order = !order;
      previous_state = true;
      if(order){
        if(i==3)
          i=1;
        else
          i=0;
      }
      else{
        if(i==0)
          i=2;
        else
          i=3;
      }
    }
     delay(50); //debouncing
  }
  else{
    previous_state=false;
  }

  //Turn a LED on
  digitalWrite(pin_LED[i], HIGH);
  delay(500);
  digitalWrite(pin_LED[i], LOW);

  if(order){
    i++;
    if(i>3)
      i=0;
  }
  else{
    i--;
    if(i<0)
      i=3;
  }

  
}
