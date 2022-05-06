def solution(board, moves):
    answer = 0
    stack=[]

    for move in moves:
        move -= 1
        for i in range(len(board)):
            if board[i][move] != 0: 
                if stack:
                    check = stack.pop()
                    if check == board[i][move]: 
                        answer += 2
                    else:
                        stack.append(check)
                        stack.append(board[i][move])
                else:
                    stack.append(board[i][move])
                board[i][move] = 0
                break
            else: continue
    print(answer)
    return answer

board=[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
moves=[1,5,3,5,1,2,1,4]

solution(board, moves)