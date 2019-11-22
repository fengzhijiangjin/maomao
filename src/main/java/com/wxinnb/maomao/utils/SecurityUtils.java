package com.wxinnb.maomao.utils;



import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;



public abstract class SecurityUtils {
    private static SecurityManager securityManager;

    public SecurityUtils() {
    }

    public static Subject getSubject(){
        Subject subject = ThreadContext.getSubject();

        if (subject == null){
            subject = (new Subject.Builder()).buildSubject();
            ThreadContext.bind(subject);
        }

        return subject;

    }

}
