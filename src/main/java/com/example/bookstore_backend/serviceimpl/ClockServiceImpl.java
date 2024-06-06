package com.example.bookstore_backend.serviceimpl;

import com.example.bookstore_backend.service.ClockService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class ClockServiceImpl implements ClockService {
    long loginTime = 0;
    String loginTimeStr = "";
    @Override
    public String start() {
        // 设置判断的要确认当前的计时器未发起，避免重复发起
        if(loginTime == 0){
            this.loginTime = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.loginTimeStr = simpleDateFormat.format(new Date(loginTime));
        }
        System.out.println(loginTime);
        System.out.println(loginTimeStr);
        return loginTimeStr;
    }

    @Override
    public String end() {
        if(loginTime > 0){
            long interval = (System.currentTimeMillis() - loginTime);
            loginTime = 0;
            long hh = interval / 1000 / 3600;
            long mm = (interval / 1000 % 3600) / 60;
            long ss = (interval / 1000 % 3600) % 60;
            long ms = (interval - (3600 * hh + 60 * mm + ss) * 1000 );
            System.out.println(interval);
            return  "Login time is : " + loginTimeStr + "\nDuration time is : " + hh + "h " + mm + "m " + ss + "s " + ms + "ms ";
        }
        else
            return "Error, Clock hasn't started";
    }
}
