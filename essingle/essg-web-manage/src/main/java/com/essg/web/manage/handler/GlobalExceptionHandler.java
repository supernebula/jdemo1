//package com.essg.web.manage.handler;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Error Handling 错误处理
// * spring boot 文档 https://docs.spring.io/spring-boot/docs/1.5.18.RELEASE/reference/htmlsingle/#boot-features-error-handling
// *
// */
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
//
//
////官方实例
////https://docs.spring.io/spring-boot/docs/1.5.18.RELEASE/reference/htmlsingle/#boot-features-error-handling
////@ControllerAdvice(basePackageClasses = FooController.class)
////public class FooControllerAdvice extends ResponseEntityExceptionHandler {
////
////    @ExceptionHandler(YourException.class)
////    @ResponseBody
////    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
////        HttpStatus status = getStatus(request);
////        return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage()), status);
////    }
////
////    private HttpStatus getStatus(HttpServletRequest request) {
////        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
////        if (statusCode == null) {
////            return HttpStatus.INTERNAL_SERVER_ERROR;
////        }
////        return HttpStatus.valueOf(statusCode);
////    }
////
////}