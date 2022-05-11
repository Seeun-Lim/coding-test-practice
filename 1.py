student_score = {'임천재': 100,'김천재': 96,'박바보':24,'임바보':22,'김바보':26,'박천재':90}

sorted_list = sorted(student_score, key=lambda x:x[1])
print(sorted_list)
