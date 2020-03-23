package com.mezjh.kcaforum.common.utils.controller;

/**
 * @author zjh
 * @date 2019/11/15
 */
//public class PageErrorController implements ErrorController {
//
//    @RequestMapping("/error")
//    public String error(HttpServletRequest request) {
//        HttpStatus httpStatus = this.getStatus(request);
//        if (httpStatus.is4xxClientError()) {
//            return "4xx";
//        }
//        return "5xx";
//    }
//
//    @RequestMapping("five")
//    public Integer makeFive() {
//        return 1 / 0;
//    }
//
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
//
//    protected HttpStatus getStatus(HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if (statusCode == null) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        } else {
//            try {
//                return HttpStatus.valueOf(statusCode);
//            } catch (Exception var4) {
//                return HttpStatus.INTERNAL_SERVER_ERROR;
//            }
//        }
//    }
//}
