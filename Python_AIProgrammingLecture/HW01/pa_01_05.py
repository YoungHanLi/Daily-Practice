#이영한/201824552/9908yong@naver.com

def SalaryIncrease(currentSalary):
    if float(currentSalary) >= 40_000:
        return currentSalary + 2_000 + (currentSalary-40_000)*0.02
    else:
        return currentSalary * 1.05

firstName = input("Enter first name: ")
lastName = input("Enter last name: ")
currentSalary = float(input("Enter current salary: "))

nextSalary = SalaryIncrease(currentSalary)


print("New salary for "+firstName+' '+lastName+': $', end='')
print(format(nextSalary, ",.2f"))
