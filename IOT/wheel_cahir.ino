const int xPin = A0; // joystick X axis connected to A0
const int yPin = A1; // joystick Y axis connected to A1
const int buttonPin = 2; // joystick button connected to digital pin 2
const int forward = 4; // first relay connected to digital pin 13
const int forward2 = 6; 
const int reverse = 5; // second relay connected to digital pin 12
const int reverse2 = 7; 
int left= 8;
int right= 9;

void setup() {
  pinMode(xPin, INPUT);
  pinMode(yPin, INPUT);
  pinMode(buttonPin, INPUT_PULLUP);
  pinMode(forward, OUTPUT);
  pinMode(forward2, OUTPUT);
  pinMode(reverse, OUTPUT);
  pinMode(reverse2, OUTPUT);
  pinMode(left, OUTPUT);
  pinMode(right, OUTPUT);
  Serial.begin(9600);
}

void allOff()
{
  digitalWrite(forward, LOW);
  digitalWrite(forward2, LOW);
  digitalWrite(reverse, LOW);
   digitalWrite(reverse2, LOW);
 digitalWrite(left, LOW);
  digitalWrite(right, LOW);
}
void loop() {
  // Read joystick X and Y positions
  int xVal = analogRead(xPin);
  int yVal = analogRead(yPin);
  
  // Read joystick button state
  bool buttonState = digitalRead(buttonPin);
  // Check joystick X axis position
  if (xVal > 900)
  {
    allOff();
    Serial.println("Forward");
    digitalWrite(forward, HIGH);
     digitalWrite(forward2, HIGH);
  }
  else if(xVal < 390)
  {
    allOff();
    Serial.println("Reverse");
    digitalWrite(reverse, HIGH);
    digitalWrite(reverse2, HIGH);
  }
  else if (yVal < 200)
  {
    allOff();
    Serial.println("Left");
    digitalWrite(left, HIGH);
  }
  else if (yVal > 1000 )
  {
    allOff();
    Serial.println("Right");
   digitalWrite(right, HIGH);
  }
  else
  {
    allOff();
  }
  // Check joystick Y axis position
//  if (yVal < 400) {
//    digitalWrite(relay2Pin, HIGH);
//  } else if (yVal > 600) {
//    digitalWrite(relay2Pin, LOW);
//  }
//  
//  // Check joystick button state
//  if (buttonState == LOW) {
//    digitalWrite(relay1Pin, HIGH);
//    digitalWrite(relay2Pin, HIGH);
//    delay(1000);
//    digitalWrite(relay1Pin, LOW);
//    digitalWrite(relay2Pin, LOW);
//  }
  delay(500);
}
