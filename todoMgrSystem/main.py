from exception.exception import * # DuplicateError , NotFoundError
from entity.models import * # id, date, title, contents, done
from view.templates import * # imput_display, ;ist_display, menu_display, menu_select etc..
from controller import view
view.load_list()

while True:
    menu_display()
    menu = menu_select()
    
    if menu == "1" :
     # 목록 보기 -> view.py의 getAllToDo() 인사목록 리턴받아서 templates의 list_display()
        ToDoList = view.getAllToDo()
        list_display(ToDoList)

    elif menu == "2" :
        # 등록 
             # DuplicateError 처리
        while True:
            submenu_display()
            sub_menu = menu_select()
            if sub_menu == "1" :
                todo = input_display()
                
                try:
                    view.register(todo)
                    message_display(todo.id+" 등록성공")
                except DuplicateError as error :
                    message_display(error)
                    
                break
            elif sub_menu == "2":
                break
            else :
                print("sub menu 1,2 중 선택")
    
    elif menu == "3" :
         # 수정 - 수정할 id 입력받고 view의 getToDo(id)로 검색한 후 
         # 해당되는 todo타입에 따라서 수정정보를 입력받은 후 view의 update(객체)
         id = id_input_display("수정")
         try:
            todo = view.getToDo(id)

            #type = ""
            #if  isinstance (todo, Todo):   ################## 이부분이 에러 ############################## ->type 필요없음 (오류 해결)
            #    type = "1"
    
            new_todo = update_input_display(id)
            view.update(new_todo)
            message_display(id +"수정성공")
         except NotFoundError as error :   # NotFoundError 처리
            message_display(error)


    elif menu == "4" :
        # 삭제할 id 입력받고 views의 remove(id) 호출
             # # NotFoundError 처리
        id = id_input_display("삭제")
        try :
            view.remove(id)
            message_display(id +" 삭제성공")
        except NotFoundError as error:
            message_display(error)

    elif menu == "5" :
        # 상세보기 - 상세보기할 id 입력받고 view의 getToDo(id) 호출
             # templates의 todo_display(todo) 호출
        id = id_input_display("검색")
        try :
            todo = view.getToDo(id)    
            person_display(todo)
        except NotFoundError as error:
            message_display(error)

    elif menu == "0" :
        view.save_list()
        message_display("일정 관리 시스템을 종료합니다.")
        break;
    
    else :
        print( )
        message_display("1,2,3,4,5,0번 중 선택하세요.")