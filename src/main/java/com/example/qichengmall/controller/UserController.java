package com.example.qichengmall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.qichengmall.entity.User;
import com.example.qichengmall.common.R;
import com.example.qichengmall.service.UserService;
import com.example.qichengmall.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    /**
     * 发送手机验证码
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        //获取手机号
        String phone = user.getPhone();
        if(!StringUtils.isEmpty(phone)) {
            //生成随机的验证码
            Integer code = ValidateCodeUtils.generateValidateCode(4);
            log.info("code={}", code);

            //调用阿里云api发送短信
            //  SMSUtils.sendMessage("瑞吉外卖","",phone,code);
            //将生成的验证码保存到session
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
            return R.success("验证码发送成功");
        }
        return R.error("手机验证码发送失败" );
    }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map map,HttpSession session){
        //获取手机号
        String phone = map.get("phone").toString();
        String code = map.get("code").toString();
        Object codeInSession = redisTemplate.opsForValue().get(phone);
        //进行验证码的比对（页面提交的验证码和Session中保存的验证码比对）
        if(codeInSession != null || codeInSession.equals(code)) {
            //如果能够比对成功，说明登录成功
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);

            User user = userService.getOne(queryWrapper);
            if (user == null) {
                //判断当前手机号对应的用户是否为新用户，如果是新用户就自动完成注册
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user", user.getId());
            redisTemplate.opsForValue();
            return R.success(user);
        }
        else {return R.error("登录失败");}
    }

    @PostMapping("/loginout")
    public R<String> loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return R.success("删除成功");
    }
}
