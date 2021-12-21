
def mycount():
    string = input("Enter a string : ")
    substring = input("Enter a substring : ")

    globalIndex = 0
    localIndex = 0
    result = 0
    
    while localIndex != -1 :
        localIndex = string[globalIndex:].find(substring)
        globalIndex += localIndex
        if localIndex != -1 :
            result += 1
            globalIndex += 1

    return result

print("Occurrences : %d" %mycount())

