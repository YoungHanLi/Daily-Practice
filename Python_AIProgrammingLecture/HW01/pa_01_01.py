# 이영한/ 201824552/ 9908yong@naver.com

old_sentence = input("Enter a sentence: ")
old_word = input("Enter word to replace: ")
new_word = input("Enter replacement word: ")

listed_sentence = old_sentence.split(' ')
removed_index = listed_sentence.index(old_word)
listed_sentence[removed_index] = new_word
new_sentence = ' '.join(listed_sentence)

print(new_sentence)
