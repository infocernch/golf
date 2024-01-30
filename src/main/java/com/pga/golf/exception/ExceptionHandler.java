package com.pga.golf.exception;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@ControllerAdvice
public class ExceptionHandler implements ErrorController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //에러페이지
    private final String ERROR_404_PAGE_PATH = "/error/error404";
    private final String ERROR_500_PAGE_PATH = "/error/error500";
    private final String ERROR_ETC_PAGE_PATH = "/error/error";



    @RequestMapping(value = "/error")
    public String handleError(HttpServletRequest request, Model model) {
        //에러코드 획득
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        //에러코드에 대한 상태 정보
        HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));

        if (status != null) {
            //httpStatus와 비교해 페이지 분기를 나누기 위한 변수
            int statusCode = Integer.valueOf(status.toString());

            //로그로 상태값을 출력
            logger.info("httpStatus : " + statusCode);

            //404에러
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                //에러 페이지에 표시할 정보
                model.addAttribute("code", status.toString());
                model.addAttribute("msg", httpStatus.getReasonPhrase());
                model.addAttribute("timestamp", new Date());
                return ERROR_404_PAGE_PATH;
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                //서버 관련 에러이기 때문에 사용자에게 정보를 제공하지 않는다.
                return ERROR_500_PAGE_PATH;
            }

        }
        //정의한 에러 외 모든 에러는 error/error 페이지
        return ERROR_ETC_PAGE_PATH;
    }
}
