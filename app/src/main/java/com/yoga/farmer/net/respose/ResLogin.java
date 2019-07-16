package com.yoga.farmer.net.respose;

/**
 * Created by Vikas on 9/12/2017.
 */

public class ResLogin {

    /**
     {
     "status": true,
     "message": "User login successful.",
     "data": {
     "id": "5",
     "first_name": "Sandeep",
     "last_name": "Naskar",
     "email": "sandipp@gmai.com",
     "password": "00dcf16d903e5890aaba465b0b1ba51f",
     "phone": "phone",
     "created": "2019-06-14 19:22:10",
     "modified": "2019-06-14 19:22:10",
     "status": "1"
     }
     }
     */

    private boolean status;
    private String message;
    private Data data;
   public class Data {
        private long id;
        private String first_name;
        private String last_name;
        private String email;
        private String phone;

       public long getId() {
           return id;
       }

       public void setId(long id) {
           this.id = id;
       }

       public String getFirst_name() {
           return first_name;
       }

       public void setFirst_name(String first_name) {
           this.first_name = first_name;
       }

       public String getLast_name() {
           return last_name;
       }

       public void setLast_name(String last_name) {
           this.last_name = last_name;
       }

       public String getEmail() {
           return email;
       }

       public void setEmail(String email) {
           this.email = email;
       }

       public String getPhone() {
           return phone;
       }

       public void setPhone(String phone) {
           this.phone = phone;
       }
   }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
