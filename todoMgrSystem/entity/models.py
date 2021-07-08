class Todo :
    def __init__(self, id, date, title, contents, done ): # Todo(id, date, title, contents, done)
        self.id = id # 일정 구분할 수 있는 id
        self.date = date # 일정 날짜
        self.title = title # 일정제목
        self.contents = contents # 일정 내용
        self.done = done # 일정이 이미 수행됐는지 진행해야하는지 true/false

    def __str__(self):
        return self.id + " , 날짜 : "+self.date + " , 제목 : "+self.title + " , 내용 : "+self.contents + " , 진행 여부 : "+self.done


