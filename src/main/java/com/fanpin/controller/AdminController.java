package com.fanpin.controller;

import com.fanpin.core.CoreUtil;
import com.fanpin.dao.IAdminDao;
import com.fanpin.entity.Admin;
import com.fanpin.util.Constants;
import com.fanpin.util.ToolsUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 地址：http://localhost:8080/technology/admin/loginpage
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private IAdminDao adminDao;

    /**
     * 管理员登录页面
     */
    @RequestMapping("/loginpage")
    public String adminToLogin() {
        return "backstage/adminlogin";
    }

    /**
     * 管理员登录
     */
    @ResponseBody
    @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public Object adminLogin(
            Admin admin,
            HttpSession session) {
        JSONObject object = new JSONObject();
        int i = adminDao.checkLogin(new Admin(admin.getAdminid(), admin.getPassword()));
        if (i > 0) {
            Admin admin_info = adminDao.selAdmByID(admin.getAdminid());
            session.setAttribute(Constants.LOGIN_ADMIN, admin_info);
            session.setAttribute("adm_info", admin_info);
            object.put("my_res", i);
        }
        return object.toString();
    }

    /**
     * 页面加载
     */
    @RequestMapping("/topage")
    public String adminPage(String page) {
        /*对登录者判断，只有超级管理员能进入某些页面*/
        Admin admin = (Admin) CoreUtil.getSession().getAttribute(Constants.LOGIN_ADMIN);
        CoreUtil.setCurrentUrl();
        if(page.equals("admin_manage")){
            if(admin.getGrade()!=1){
                return "backstage/backpage";
            }
        }
        return "backstage/"+page;
    }

    @ResponseBody
    @RequestMapping(value = "/getadminlist", produces = "application/json;charset=UTF-8")
    public Map<String, Object> getAdminList(){
        Map<String, Object> map=new HashMap<String, Object>();
        List<Admin> list = adminDao.getAdminList();
        map.put("adm_list", list);
        return map;
    }

    @RequestMapping(value = "/addAdmin")
    public ModelAndView addAdmin(Admin admin){
        ModelAndView view = new ModelAndView();
        admin.setAimg("21322423.gif");
        admin.setGrade(2);
        int i = adminDao.addAdmin(admin);
        view.addObject("adm_del", i);
        view.setViewName("backstage/admin_manage");
        return view;
    }

    @RequestMapping(value = "/deleteAdmin")
    public ModelAndView deleteAdmin(Integer adminid){
        ModelAndView view = new ModelAndView();
        int i = adminDao.deleteAdminById(adminid);
        view.addObject("adm_del", i);
        view.setViewName("backstage/admin_manage");
        return view;
    }

    @ResponseBody
    @RequestMapping(value = "/alterAdmin", produces = "application/json;charset=UTF-8")
    public Map<String, Object> alterAdmin(Admin admin){
        Map<String, Object> map=new HashMap<String, Object>();
        int i = adminDao.updateAdminById(admin);
        System.out.println(admin);
        map.put("adm_alter", i);
        return map;
    }
}
