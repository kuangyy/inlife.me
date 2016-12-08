package me.inlife.website.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.inlife.website.exception.BusinessException;
import me.inlife.website.util.WebHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by kuangye on 2016/12/8.
 */
public abstract class BaseController {

    private static Logger logger = LogManager.getLogger(BaseController.class);

    @Resource
    private Validator validator;

    @ModelAttribute
    private void initAttribute(ModelMap model) {
        model.put("sys_time", Calendar.getInstance().getTimeInMillis());
    }

    protected void output(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object object) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.output(httpRequest, httpResponse, object, dateFormat);
    }

    /**
     * API输出
     *
     * @param httpRequest  HttpServletRequest
     * @param httpResponse HttpServletResponse
     * @param object       需要输出的Object
     */
    protected void output(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object object, DateFormat dateFormat) {
        OutputStream ps = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(dateFormat);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        if (WebHelper.isAjax(httpRequest)) {
            try {
                ps = httpResponse.getOutputStream();
                ps.write(objectMapper.writeValueAsString(object).getBytes("UTF-8"));
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                throw new BusinessException(e.getMessage(), -1);
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            try {
                httpResponse.sendRedirect("/404");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 异常处理,当捕获异常时统一使用此方法处理
     *
     * @param request
     * @param response
     * @param ex
     */
    @ExceptionHandler
    private void exceptionProcess(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml; charset=utf-8");

        output(request, response, ex);
    }

    public ModelAndView goError() {
        return new ModelAndView("redirect:/404");
    }

    public JSONObject getJSON() {
        JSONObject json = new JSONObject();
        json.put("status", -1);
        return json;
    }

}
