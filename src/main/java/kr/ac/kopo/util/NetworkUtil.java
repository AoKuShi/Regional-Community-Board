package kr.ac.kopo.util;

import jakarta.servlet.http.HttpServletRequest;

public class NetworkUtil {
    public static String getClientIP(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
}
