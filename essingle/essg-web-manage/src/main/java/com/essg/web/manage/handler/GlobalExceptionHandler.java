package com.essg.web.manage.handler;//package com.essmp.web.admin.handler;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice //Controller通知
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(value=Exception.class)
//    @ResponseBody
//    private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e)
//    {
//        Map<String, Object> modelMap = new HashMap<>();
//        modelMap.put("success", false);
//        modelMap.put("errMsg", e.getMessage());
//        modelMap.put("stackTrace", e.getStackTrace());
//        modelMap.put("ex", e.toString());
//        return modelMap;
//    }
//}
