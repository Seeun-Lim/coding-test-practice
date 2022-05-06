def solution(id_list, report, k):
    answer=[]
    report=set(report)
    report_list={}
    delete=[]

    for id in id_list:
        report_list[id]=[0,0]


    for rep in report:
        a,b = rep.split()

        report_list[a].append(b)
        report_list[b][1]+=1

        if report_list[b][1] == k:
            delete.append(b)
            
    for rep in report_list:
        for id in delete:
            if id in report_list[rep]:
                report_list[rep][0] += 1
        answer.append(report_list[rep][0])
    
    return answer