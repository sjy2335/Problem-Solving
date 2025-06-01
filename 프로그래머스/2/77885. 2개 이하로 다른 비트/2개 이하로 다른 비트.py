def solution(numbers):
    answer = []
    for number in numbers:
        if number % 2 == 0:
            answer.append(number + 1)
        else:
            bit = 1
            while number & bit: # 처음 등장하는 0을 찾고 그 오른쪽 비트(1) 하나 0으로
                bit <<= 1
            answer.append((number | bit) & ~(bit >> 1))
    return answer