def solution(record):
    answer = []
    enter_name={}
    
    for rec in record:
        info = rec.split()
        if info[0] in ['Enter','Change']:
            enter_name[info[1]] = info[2]

    for rec in record:
        info = rec.split()
        if info[0] == 'Enter':
            answer.append(enter_name[info[1]]+'님이 들어왔습니다.')
        elif info[0] == 'Leave':
            answer.append(enter_name[info[1]]+'님이 나갔습니다.')
            
    return answer

record=["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]

solution(record)