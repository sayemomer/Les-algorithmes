def calculate_characters_to_enter(word_list):
    unique_words = set(word_list)
    total_characters = 0

    for word in unique_words:
        prefix = ''
        for char in word:
            prefix += char
            if sum(1 for w in unique_words if w.startswith(prefix)) == 1:
                break
        print(prefix)
        total_characters += len(prefix)

    return total_characters

# Input
input_line = input()
word_list = input_line.split(',')

# Calculate the number of characters to enter
result = calculate_characters_to_enter(word_list)
print(result)
