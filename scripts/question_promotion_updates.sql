insert into question_promotion (id, version, answers_to_win, correct_message, current_question_id, current_question_date, date_created, days_to_win, description, end_date, incorrect_message, last_updated, logged_in_creative, logged_out_creative, name, not_available_message, quota, remaining_quota, start_date, status, survey_id, winning_message) values (1, 2, 1, 'That is the correct answer! Play again tomorrow.', 23, '2010-08-10 00:00:00', '2010-08-10 17:30:08', 365, null, null, 'Sorry, that is not the correct answer. Try again tomorrow!', '2010-08-10 17:31:35', null, null, 'Test Question Promotion', 'This promotion is no longer available.', 2, 1, '2010-08-10 17:30:08', 'ACTIVE', 1, 'You are a winner!');

insert into question (id, version, date_created, last_updated, question_text, title, type) values (21, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 'Three of these Major League Baseball teams lasted only one season. The other lasted for over 20 years. Which team was it?', 'Short Lived Baseball Teams', 'PROMOTION');
insert into question (id, version, date_created, last_updated, question_text, title, type) values (22, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 'In the 2002 New York City Marathon, which country finished first, second, and third, in the men''s division?', '2002 NYC Marathon Winners', 'PROMOTION');
insert into question (id, version, date_created, last_updated, question_text, title, type) values (23, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 'The great Olympic swimmer Mark Spitz, won 11 medals in his two Olympics. How many medals were Gold?', 'Mark Spitz Gold Medals', 'PROMOTION');
insert into question (id, version, date_created, last_updated, question_text, title, type) values (24, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', ' Which team won the 2002 Major League Soccer (MLS) Cup?', '2002 MLS Winner', 'PROMOTION');

insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (78, 0, 1, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 21, 'Boston Beaneaters');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (79, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 21, 'St. Louis Perfectos');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (80, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 21, 'Broklyn Atlantics');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (81, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 21, 'Seattle Pliots');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (82, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 22, 'Japan');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (83, 0, 1, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 22, 'Kenya');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (84, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 22, 'Poland');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (85, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 22, 'United States');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (86, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 23, '3');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (87, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 23, '15');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (88, 0, 1, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 23, '9');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (89, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 23, '2');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (90, 0, 1, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 24, 'Galaxy');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (91, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 24, 'MetroStars');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (92, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 24, 'There was not Cup held in 2002');
insert into response (id, version, correct, date_created, last_updated, question_id, response_text) values (93, 0, 0, '2010-08-10 17:30:08', '2010-08-10 17:30:08', 24, 'D.C. United');

insert into survey (id, version, date_created, last_updated, title) values (1, 1, '2010-08-10 17:30:08', '2010-08-10 17:31:27', 'Test Question Promotion');

insert into survey_question (survey_questions_id, question_id) values (1, 21);
insert into survey_question (survey_questions_id, question_id) values (1, 22);
insert into survey_question (survey_questions_id, question_id) values (1, 24);
