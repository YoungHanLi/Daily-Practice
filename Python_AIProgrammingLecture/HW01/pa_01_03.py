# 이영한/ 201824552/ 9908yong@naver.com

startingWord = "NAISNIENLGELTETWEORRSD"

crossedOutLetters = startingWord[::2]
remainingLetters = startingWord[1::2]

print("Starting word: ", end='')
print(startingWord)

print("Crossed out letters: ", end='')
print(' '.join(list(crossedOutLetters)))

print("Remaining letters: ", end='')
print(' '.join(list(remainingLetters)))
