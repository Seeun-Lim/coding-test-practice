num_english={'zero':0,'one':1,'two':2,'three':3,'four':4,'five':5,'six':6,'seven':7,'eight':8,'nine':9}
s="1zerotwozero3"

def solution(s):
    answer=''

    english=''

    for item in s:
        if item >= '0' and item <= '9':
            answer += item
        else:
            english += item
            if english in num_english:
                answer += str(num_english[english])
                english=''

    print(answer)

    
    return answer

solution(s)