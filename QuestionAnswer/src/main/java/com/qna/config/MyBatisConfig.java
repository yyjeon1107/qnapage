package com.qna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qna.dao.AnswerBoardMapper;
import com.qna.dao.AnswerBoardRepository;
import com.qna.dao.MemberMapper;
import com.qna.dao.MemberRepository;
import com.qna.dao.MyBatisAnswerBoardRepository;
import com.qna.dao.MyBatisMemberRepository;
import com.qna.dao.MyBatisQuestionBoardRepository;
import com.qna.dao.QuestionBoardMapper;
import com.qna.dao.QuestionBoardRepository;
import com.qna.service.AnswerBoardService;
import com.qna.service.AnswerBoardServiceImpl;
import com.qna.service.MemberService;
import com.qna.service.MemberServiceImpl;
import com.qna.service.QuestionBoardService;
import com.qna.service.QuestionBoardServiceImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final MemberMapper memberMapper;
    private final QuestionBoardMapper questionBoardMapper;
    private final AnswerBoardMapper answerBoardMapper;

        
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MyBatisMemberRepository(memberMapper);
    }

    @Bean
    public QuestionBoardService questionBoardService() {
        return new QuestionBoardServiceImpl(questionBoardRepository());
    }

    @Bean
    public QuestionBoardRepository questionBoardRepository() {
        return new MyBatisQuestionBoardRepository(questionBoardMapper);
    }
    
    
    @Bean
    public AnswerBoardService answerBoardService() {
    	return new AnswerBoardServiceImpl(answerBoardRepository());
    }
    
    @Bean 
    public AnswerBoardRepository answerBoardRepository() {
    	return new MyBatisAnswerBoardRepository(answerBoardMapper);
    }
    
}
