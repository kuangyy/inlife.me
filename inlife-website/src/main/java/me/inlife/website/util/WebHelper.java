package me.inlife.website.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * WebHelper
 *
 * @author liwei
 * @date 16/8/4
 * @description Web常用方法帮助类
 */
public class WebHelper {
    public static String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookie = request.getCookies();
        String cookieValue = null;
        if (cookie != null) {
            for (int i = 0; i < cookie.length; i++) {
                if (cookie[i].getName().equals(cookieName) == true) {
                    cookieValue = cookie[i].getValue();
                    break;
                }
            }
        }
        return cookieValue;
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String value) {
        setCookie(response, cookieName, value, null);
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String value, String domain) {
        setCookie(response, cookieName, value, null, domain, null);
    }

    public static void delCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String value, Integer expiry, String domain, String path) {
        try {
            Cookie cookie;
            cookie = new Cookie(cookieName, URLEncoder.encode(value, "UTF-8"));
            if (expiry != null) {
                cookie.setMaxAge(expiry);
            }
            if (domain != null && !domain.equals("")) {
                if (!domain.startsWith(".")) {
                    domain = "." + domain;
                }
                cookie.setDomain(domain);
            }
            if (path != null) {
                cookie.setPath(path);
            } else {
                cookie.setPath("/");
            }
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    /**
     * @param request
     * @return
     * @throws
     * @Title: getUseAgent
     * @Description: 获取useragent
     * @author yinqiang
     */
    public static String getUseAgent(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        String regex = ";\\s?(\\S*?\\s?\\S*?)\\s?(Build)?/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userAgent);
        String agent = null;
        if (matcher.find()) {
            agent = matcher.group(1).trim();
        }
        return agent;
    }

    /**
     * 过滤脚本注入
     */
    public static String encode(String value) {
        if (value != null) {
            return value.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
                    .replaceAll("\"", "&quot;").replaceAll("'", "&acute;");
        } else {
            return null;
        }
    }

    public static Boolean isSpider(HttpServletRequest request) {
        boolean isSpider = false;
        String[] spiderAgents = {"baiduspider", "googlebot", "bingbot", "haosouspider"};
        if (request.getHeader("User-Agent") != null) {
            for (String spiderAgent : spiderAgents) {
                if (request.getHeader("User-Agent").toLowerCase().indexOf(spiderAgent) >= 0) {
                    isSpider = true;
                    break;
                }
            }
        }
        return isSpider;
    }

    /**
     * 获取客户端IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取是否为AJAX请求
     */
    public static boolean isAjax(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if (StringUtils.hasText(requestType)) {
            return true;
        }
        return false;
    }
}
