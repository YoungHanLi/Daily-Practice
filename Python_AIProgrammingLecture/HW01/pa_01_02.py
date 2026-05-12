#이영한/201824552/9908yong@naver.com

coefficient = float(input("Enter coefficient of restitution: "))
ini_height = float(input("Enter initial height in meters: "))

height = ini_height
meters = 0.0
bounce = 0

while height>=0.10:
    meters += height #down
    height = height*coefficient
    bounce+=1
    if height>=0.10:
        meters += height #up


print("Number of bounces: %d" %bounce)
print("meters traveled: %.2f" %meters)
