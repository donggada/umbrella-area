package com.example.umbrellaarea.umbrellaarea.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "LogId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        log.info("REQUEST [{}][{}][{}]", uuid, requestURI, handler);
        request.setAttribute(LOG_ID, uuid);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        String log_id = (String)request.getAttribute(LOG_ID);

        log.info("RESPONSE [{}][{}]", log_id, requestURI);

        if (ex != null) {
            log.error("ERROR !!! " , ex);
        }
    }
}
