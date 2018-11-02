package com.cheeryhu.java.cache;

public class UserMain {

   public static void main(String[] args){
       UserService userService = new UserService();

       userService.getUserById("001");
       userService.getUserById("001");
       userService.reload();

       System.out.println("after reload...");

       userService.getUserById("001");
       userService.getUserById("001");
   }
}
