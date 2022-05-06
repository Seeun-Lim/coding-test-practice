new_id="abcdefghijklmn.p"
new_id = new_id.lower()
stack=[]
answer=''

def checkPoint(stack):
    if len(stack) == 0: return False
    check = stack.pop()

    if check != '.': 
        stack.append(check)
        return False
    else:
        checkPoint(stack)


for ch in new_id:
    if ch == '-' or ch=='_':
        stack.append(ch)
    if ch >= '0' and ch<='9' or ch>='a' and ch<='z':
        stack.append(ch)
    if ch=='.':
        if len(stack) != 0:
            checkPoint(stack)
        else:
            continue
        stack.append(ch)

if len(stack) != 0 and stack[len(stack)-1] == '.':
    stack.pop()

if len(stack) == 0:
    stack.append('a')

if len(stack) >= 16:
    while len(stack) != 15:
        stack.pop()
    if stack[len(stack)-1] == '.':
        stack.pop()

if len(stack) <=2:
    repeat = stack.pop()
    while len(stack) != 3:
        stack.append(repeat)

for item in stack:
    answer += item

print(answer)
    