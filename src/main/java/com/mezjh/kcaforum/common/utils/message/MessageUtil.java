package com.mezjh.kcaforum.common.utils.message;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zjh
 * @date 2020/3/24
 */
@Component
public class MessageUtil {

    @Autowired
    private MessageConfig messageConfig;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void send(String phoneNumber) {
        String captcha = getRandomCaptcha(phoneNumber);
        int appid = Integer.parseInt(messageConfig.getAppId());
        String appkey = messageConfig.getAppKey();
        int templateId = Integer.parseInt(messageConfig.getRegisterTemplateId());
        String smsSign = messageConfig.getSign();
        try {
            String[] params = {captcha,"10"};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
//            if (!redisTemplate.opsForValue().get(phoneNumber+"msgFlag").isEmpty()) {
//                throw new Exception("请60s之后再试!");
//            }
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,
                templateId, params, smsSign, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getRandomCaptcha(String phoneNumber){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        //将当前验证码放入缓存s
        redisTemplate.opsForValue().set(phoneNumber+"msgFlag", str.toString(), 60, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(phoneNumber+"msg",str.toString(),600, TimeUnit.SECONDS);
        return str.toString();
    }

}
