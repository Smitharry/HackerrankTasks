def is_professor_angry(threshold, arrival_times) :
    '''Print if class is cancelled.'''
    if count_arrival_on_time(arrival_times) < threshold :
        print('YES')
    else :
        print('NO')

def count_arrival_on_time(arrival_times):
    '''Count number of students who arrived on time'''
    students_on_time = list(filter(lambda time : time <= 0, arrival_times))
    return len(students_on_time)

if __name__ == '__main__':
    number_of_cases = int(input())
    for case in range(number_of_cases):
        case_info = input().split()
        threshold = int(case_info[1])
        arrival_times = list(map(int, input().rstrip().split()))
        is_professor_angry(threshold, arrival_times)

