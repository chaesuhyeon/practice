from controller import view
from entity.models import *
import os.path

def save_file(ToDo):
    # 프로그램 종료시 views.py persons list 를 파일저장
    save_file = open("list.dat", "w")
    for index, t in enumerate(view.todos) :
        if isinstance(t,Todo):

            save_file.write("1, {0},{1},{2}, {3},{4}\n".format(t.id, t.date, t.title, t.contents, t.done))

    save_file.close()
    
def init_data_load():
    todos =[]

    # 프로그램 시작시 파일읽어서 view.py persons list에 저장
    fileExist = os.path.isfile("list.dat") # os.path 패키지를 이용해서 파일 존재여부 확인
    if fileExist :
        read_file = open("list.dat", "r") # read mode로 파일 연결
        while True:
            data = read_file.readline() # 한 라인씩 읽기 / type, id, name, major 또는 subject 또는 department
                                        # type = 1 - student, type = 2 - Instructor , type = 3 - Employee
            date_list = data.split(",")  # ,을 기준으로 나눔, 쪼갬(,로 구분해서 데이터 리스트 할당)
           # 읽은 한 라인의 데이터 문자열열을 해당 타입의 객체로 생성
            todo = None
            
            todos.append(todo) # 객체 데이터 리스트에 저장 후 추가

            if not data : break # 더이상 읽어들일게 없을때 (readline 읽어드릴 데이터가 없는 경우)
                                # 무한 loop 빠져나가기
        read_file.close() # 자원 반납
    return todos # 파일의 데이터 객체로 저장한 리스트 리턴



