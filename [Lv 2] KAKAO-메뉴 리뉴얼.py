from itertools import combinations

def solution(orders, course):
    answer = []

    for length in course:
        comb_list=[]
        find_comb={}

        for order in orders:
            if len(order) >= length:
                order_list = list(order)

                comb_list.sort()
                order_list.sort()


                if len(comb_list) == 0: comb_list += [list(elem) for elem in list(combinations(order_list,length))]
                else:
                    for elem in list(combinations(order_list,length)):
                        if list(elem) in comb_list:
                            string=''
                            for e in list(elem):
                                string += str(e)
                            if string in find_comb: find_comb[string] += 1
                            else: find_comb[string] = 2
                        else: 
                            comb_list.append(list(elem))


        if find_comb:
            max_value = max(find_comb.values())
            for key in find_comb:
                if max_value == find_comb[key]:
                    answer.append(key)
            
        
    answer.sort()
    return answer

orders=["XYZ", "XWY", "WXA"]
course=[2,3,4]

solution(orders,course)