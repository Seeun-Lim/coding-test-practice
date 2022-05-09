def solution(lottos, win_nums):
    answer = [0,0]
    win={6:1,5:2,4:3,3:4,2:5,1:6,0:6}

    min_check = 0
    max_check = 0

    for num in lottos:
        if num in win_nums:
            min_check+=1
        elif num == 0:
            max_check +=1

    answer[0], answer[1] = win[min_check + max_check],win[min_check]
    
    return answer