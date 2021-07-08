from entity.models import Todo

# menu display
def menu_display():
    print("======= 일정 관리 시스템 ======= ")
    print("1. 전체 목록 보기 ")
    print("2. 일정 등록 ")
    print("3. 일정 수정 ")
    print("4. 일정 삭제 ")
    print("5. 일정 상세보기")
    print("0. 시스템 종료")
    
# submenu display
def submenu_display( ):
    print("1. 일정 작성")
    print("2. main menu로 이동")

# menu select(메뉴 입력받기)
def menu_select( ):
    menu = input("메뉴를 선택하세요 : ")
    return menu

# message display
def message_display(message):
    print(message)

# list display # 목록 받아다가 화면에 display하기
def list_display(todo_list):
    print("=== 전체 목록 ===")
    for todo in todo_list:
        print(todo)  ############

# register todo input
def input_display():
    id = input("아이디를 입력하세요 : ")
    date = input("일정 날짜를 입력하세요 : ")
    title = input("일정 제목을 입력하세요 : ")
    contents = input("일정 내용을 입력하세요 : ")
    done = input("일정 수행여부를 입력하세요 : ")
    return Todo(id, date, title, contents, done)

# update todo input
# 수정하거나 삭제또는 상세보기를 위한 id 입력
def id_input_display(command):
    id = input("{0} id는 ? ".format(command))
    return id

# todo display
def person_display(todo):
    print("=== 상세 정보 ===")
    print(todo)    ######

# 수정할 데이터 입력 화면    
def update_input_display(id):
    date = input("일정 날짜를 입력하세요 : ")
    title = input("일정 제목을 입력하세요 : ")
    contents = input("일정 내용을 입력하세요 : ")
    done = date = input("일정 수행여부를 입력하세요 : ")
    return Todo(id, date, title, contents, done)

