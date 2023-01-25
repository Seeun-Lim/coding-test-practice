numbers=[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
hand = "right"

def solution(numbers, hand):
    answer=''
    keypad={1:[1,1],2:[1,2],3:[1,3],4:[2,1],5:[2,2],6:[2,3],7:[3,1],8:[3,2],9:[3,3],'*':[4,1],0:[4,2],'#':[4,3]}

    l=[1,4,7]
    r=[3,6,9]

    current_left = keypad['*']
    current_right = keypad['#']

    for num in numbers:
        if num in l:
            current_left=keypad[num]
            answer += 'L'
        elif num in r:
            current_right=keypad[num]
            answer += 'R'
        else:
            position = keypad[num]
            left_distance =abs(current_left[0]-position[0]) + abs(current_left[1]-position[1])
            right_distance = abs(current_right[0]-position[0]) + abs(current_right[1]-position[1])
            
            if left_distance<right_distance:
                answer += 'L'
                current_left = position
            elif left_distance>right_distance:
                answer += 'R'
                current_right = position
            else:
                if hand == 'right':
                    current_right = position
                    answer += 'R'
                else:
                    current_left = position
                    answer += 'L'
    print(answer)

    return answer

solution(numbers, hand)