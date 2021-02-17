class Student(object):

    def __init__(self,name,cgpa):
        self.name = name
        self.cgpa = cgpa
    # this is overloading
    def __lt__(self,other):
        return self.name < other.name
    
students = [
    Student('B', 4.0),
    Student('A', 3.0)
]

#sort library use mostly quicksort which has O(nlog n) complexity

students_sorted_by_name = sorted(students)

sort_student_by_name = students.sort(key=lambda student : student.cgpa)

# print(students_sorted_by_name[0].name)

test = [4,2,5]
sorted_test = sorted(test)
print(sorted_test)


students = [
     {
        'name': 'B',
        'cgpa': 3.0
    },
    {
        'name': 'A',
        'cgpa': 4.0
    }
]

# this assignment doesn't work because sort() returns none
sort_student = students.sort(key=lambda student : student['name'])
print(sort_student)

#ascending 
students.sort(key=lambda student : student['cgpa'])
print(students)

#descending 
students.sort(key=lambda student : student['cgpa'] , reverse=True)
print(students)