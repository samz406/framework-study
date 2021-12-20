package org.samz.resilience4j.demo;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: lilin
 * @Date: 2021/12/20 16:14
 * @Description:
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {


    @Override
    public String getUser(Integer id) {

        log.info("请求入参为：{}",id);
        if (id % 2 == 0) {
            throw new RuntimeException("查询异常");
        }

        return "用户id为" + id;
    }

    @Override
    public String recover(RuntimeException r, Integer id, String result) {

        System.out.println("recover:收到的消息为," + id + " 异常为:" + r.getMessage());
        return "没有找到数据";
    }
}
