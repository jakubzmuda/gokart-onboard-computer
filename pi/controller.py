import RPi.GPIO as GPIO
from signal import pause
from time import sleep

pin = 12
duty = 0

GPIO.setmode(GPIO.BOARD)
GPIO.setup(pin,GPIO.OUT)
motor_pwm = GPIO.PWM(pin,1000)
motor_pwm.start(0)
motor_pwm.ChangeDutyCycle(100)

print("running...")

try:
    while True:
        user_input = input()
        if user_input == '1':
            duty += 1
            motor_pwm.ChangeDutyCycle(duty)
            print("speed 1")
            print(duty)

except KeyboardInterrupt:
    GPIO.cleanup()
    print("GPIO clean up")
