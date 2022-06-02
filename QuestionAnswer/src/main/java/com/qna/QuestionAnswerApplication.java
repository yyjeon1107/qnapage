package com.qna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.qna.config.MyBatisConfig;

@Import(MyBatisConfig.class)
@SpringBootApplication
public class QuestionAnswerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionAnswerApplication.class, args);
	}

}
