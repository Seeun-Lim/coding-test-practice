def sortInsert(arr, plays, idx):
    new_data = plays[idx]
    length = len(arr)
    if length == 0: arr.append(idx)
    else:
        arr.append('')
        for i in range(length-1,-1,-1):
            if new_data>plays[i]:
                arr[i+1] = arr[i]
            elif new_data == plays[i] and idx<i:
                arr[i+1] == arr[i] 
            else: 
                i += 1
                break
        arr[i] = idx
    return arr
        
def solution(genres, plays):
    answer = []
    play_list = {}
    play_count = {}
    
    for i in range(len(genres)):
        if genres[i] not in play_list: 
            play_list[genres[i]]=[]
            play_count[genres[i]] = 0
            
        play_count[genres[i]] += plays[i]
        sortInsert(play_list[genres[i]], plays, i)

    print(play_count, play_list)
    sort_play_count = sorted(play_count.items(), key=lambda item: item[1], reverse=True)

    for genre in sort_play_count:
        print(genre)
        print(play_list[genre[0]][0],play_list[genre[0]][1])
        answer.append(play_list[genre[0]][0])
        if play_list[genre[0]][1]>=0: answer.append(play_list[genre[0]][1])
    
    print(answer)
    return answer

genres=["classic", "pop", "classic", "pop", "classic"]	
plays=[500,750,500,750,500]

solution(genres, plays)
print('------------------------')


genres=["classic", "pop", "classic", "classic", "pop"]	
plays=[500,600,150,800,2500]

solution(genres, plays)