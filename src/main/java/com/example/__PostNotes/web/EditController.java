package com.example.__PostNotes.web;

import com.example.__PostNotes.service.CourseService;
import com.example.__PostNotes.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EditController {
//    //透過 @RequestMapping 指定從/會被對應到此hello()方法
//    @Autowired
//    private StudentService studentService;
//    @Autowired
//    private CourseService CourseService;
//
//
//
//    public EditController() {
//    }

//    @RequestMapping("/")
//    public String save(Title title, RedirectAttributes attributes, HttpSession session){
//        blog.setType(typeService.getType(title.getType().getId()));
//        blog.setTags(tagService.listTag(title.getTagIds()));
//        Title b;
//        if (title.getId() == null) {
//            b =  titleService.saveBlog(title);
//        } else {
//            b = titleService.updateBlog(title.getId(), title);
//        }
//        if(b == null){
//            attributes.addFlashAttribute("message","操作失敗");
//        }else{
//            attributes.addFlashAttribute("message","操作成功");
//        }
////        memberAccount = new MemberAccount();
////        memberAccount.setPassword("12345678");
////        memberAccount.setEmail("test@gmail.com");
////        memberAccount.setCellphone("0912345789");
////        memberAccount.setAddress("台北市");
////        memberService.addMember(memberAccount);
//        return "Edit";
//    }
}