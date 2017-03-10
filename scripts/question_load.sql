ALTER TABLE esmzone.question MODIFY COLUMN question_text TEXT NOT NULL


CREATE
    TABLE question_load
    (
        id bigint NOT NULL,
        description text NOT NULL,
        question_text text NOT NULL,
        question_id bigint
    )

CREATE
    TABLE response_load
    (
        question_id bigint NOT NULL,
        response_text text NOT NULL,
        correct TINYINT(1)
    )
    
insert into question (version,date_created,last_updated,question_text,title,type)
select 0, now(), now(), question_text, description, "PROMOTION"
from question_load

update question_load t1, question t2
set t1.question_id = t2.id
where t1.question_text = t2.question_text

insert into response (version, correct, date_created, last_updated, question_id, response_text)
select 0, correct, now(), now(), t2.question_id, response_text
from response_load t1, question_load t2
where t1.question_id = t2.question_id
