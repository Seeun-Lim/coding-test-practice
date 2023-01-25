def compression(check):
    output = []
    current = check[0]
    length = 0
    repeat = 1

    for a,b in zip(check, check[1:]+['']):
        if a == b:
            repeat += 1
        else:
            output.append([current,repeat])
            current = b
            repeat = 1
    
    for word , cnt in output:
        if cnt != 1: 
            length += 1
        length += len(word)
    return length
        

def solution(s):
    answer = len(s)

    for i in range(1, len(s)//2+1):
        check=[s[j:j+i] for j in range(0,len(s),i)]
        if compression(check) < answer:
            answer = compression(check)
    return answer


s="abcabcabcabcdededededede"
print(solution(s))