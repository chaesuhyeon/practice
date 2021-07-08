#class DuplicateError(Exception):
#    def __init__(self, message):
#        self.__init__(message+" 이미 존재합니다.") 

#    def __str(self):
#        return self.__str__()

#class NotFoundError(Exception):
#    def __init__(self,message):
#        self.__init__(message+" 존재하지 않습니다.")
        #self.message = message
    
#    def __str(self):
#        return self.__str__()

class DuplicateError(Exception): #아이디가 중복되는경우
    def __init__(self, message):
        super().__init__(message+" 이미 존재합니다.")
        #self.message = message
    
    def __str(self):
        return super().__str__()

class NotFoundError(Exception):
    def __init__(self,message):
        super().__init__(message+" 존재하지 않습니다.")
        #self.message = message
    
    def __str(self):
        return super().__str__()
