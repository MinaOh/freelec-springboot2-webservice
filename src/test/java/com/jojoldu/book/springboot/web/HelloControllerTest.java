package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //테스트를 진행할 때 내장된 실행자가 아닌 스프링 실행자를 사용한다
@WebMvcTest //Controller 쓰려고 붙여
public class HelloControllerTest {

    @Autowired //Bean을 주입받는다.
    private MockMvc mvc; //Spring MVC의 시작

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) //Http header의 status(200,404,500 등) 상태 검증
                .andExpect(content().string(hello)); //본문의 내용 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))).andExpect(status().isOk()).andExpect(jsonPath("$.name", is(name))).andExpect(jsonPath("$.amount", is(amount)));
    }

}
