package cn.edu.guet.controller;

import cn.edu.guet.bean.Users;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;

public class UserController {
    @Controller
    public class UserCotroller {
        @RequestMapping("user/addUser.do")
        public String addUser(Users user){
            System.out.println("dedaode:"+user.getUsername());
            System.out.println("dedaode:" + user.getPassword());
            return "forward:viewUser.jsp";
        }
        @RequestMapping("user/viewUser.do")
        public Users viewUser(){
            Users users=new Users();
            users.setUsername("wangwu");
            users.setPassword("ww1234");
            return users;
        }@RequestMapping("dxyz.do")
        public String dxyz(Users user){
            //System.out.println("dedaode:"+user.getUsername());
            //System.out.println("dedaode:" + user.getPassword());
            return "forward:dxyz.jsp";
        }
    }

}
