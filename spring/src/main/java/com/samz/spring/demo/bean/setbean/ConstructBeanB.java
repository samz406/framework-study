package com.samz.spring.demo.bean.setbean;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author: lilin
 * @Date: 2022/5/6 17:08
 * @Description:
 */
@Service
public class ConstructBeanB {


    public ConstructBeanB(ConstructBeanB1 constructBean) {

    }
}


@Service
class ConstructBeanB1 {

}

@Service
class ConstructBeanB2 {


    private List<ConstructAPI> list;
    //注入一个集合对象,
    public ConstructBeanB2(List<ConstructAPI> list) {

        this.list = list;
    }

}



