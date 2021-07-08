from exception.exception import *
from dao.file_registry import *

todos=[]

def register(todo):
    print("view register =======",todo)
    #id 중복 check  - 중복될 경우 DuplicateError 발생시킴
    index = is_exist(todo.id)
    if index > -1:  # 1-보다 크면 id 존재한다는 뜻(중복된다는 뜻)
        raise DuplicateError(todo.id)
    todos.append(todo) # 중복되는게 아니라면 아이디 추가해라

def update(todo):
    # id check - 존재하지 않는 경우 NorFoundError 발생시킴
    index = is_exist(todo.id)
    if index == -1: # -1은 존재하지 않는다는 뜻
        raise NotFoundError(todo.id)
    todos[index] = todo # 존재하면 업데이트 시켜라

def remove(id):
    # id check - 존재하지 않는 경우 NorFoundError 발생시킴
    index = is_exist(id)
    if index == -1: # -1은 존재하지 않는다는 뜻
        raise NotFoundError(id)
    todos.pop(index) # pop으로 해당되는 인덱스 요소 끄집어 내서 삭제

def getToDo(id):
    # id check - 존재하지 않는 경우 NorFoundError 발생시킴
    index = is_exist(id)
    if index == -1:
        raise NotFoundError(id)
    return todos[index]

def getAllToDo():
    return todos

def is_exist(id):
    for index, todo in enumerate(todos):
        if todo.id == id:
            return index
    return -1 # -1은 존재하지 않는다는 뜻

def save_list():
    save_file(todos)

def load_list():
    global todos
    todos = init_data_load()