def solution(numbers):
    num=[0,1,2,3,4,5,6,7,8,9]
    answer = 0

    for n in num:
        if n not in numbers:
            answer += n

    print(answer)
    return answer

numbers=[5,8,4,0,6,7,9]
solution(numbers)