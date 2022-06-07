create table answerboard(
answer_board_id int(45) not null auto_increment primary key,
member_name varchar(45),
title varchar(100),
content text,
question_board_id int(45),
reg_dtime datetime DEFAULT CURRENT_TIMESTAMP,
mod_dtime datetime DEFAULT CURRENT_TIMESTAMP
);
