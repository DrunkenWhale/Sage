package com.sage

case class Request() {
  
}


object Request {

  extension (self: Request) {
    // lambda slot
    // can be used in any place before request entry flow
    def ~>(lambda: Request => Request): Request = {
      lambda(self)
    }
    
    def ~>(workflow: Workflow): Unit ={
      
    }
    
  }

}
