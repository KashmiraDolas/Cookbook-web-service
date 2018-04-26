CREATE TABLE directions_table
(
direction_id text,	
title	text,
directions text,
PRIMARY key (direction_id, title)
);

CREATE TABLE reciepe_table
(
receipe_id INTEGER,
title text, 
rating FLOAT,
calories FLOAT,
protein FLOAT,
fat FLOAT,
sodium FLOAT,
bacon INTEGER,
beef INTEGER,
brownrice INTEGER,
chicken INTEGER,
duck INTEGER,
egg INTEGER,
eggplant INTEGER,
ham INTEGER,
mushroom INTEGER,
noodle INTEGER,
oatmeal INTEGER,
pasta INTEGER,
pork INTEGER,
potato INTEGER,
quail INTEGER,
quinoa INTEGER,
rice INTEGER,
seafood INTEGER,
sweetpotato INTEGER,
veal INTEGER,
venison INTEGER,
turkey INTEGER,
PRIMARY key (receipe_id, title)
);

COPY reciepe_table FROM '/Users/CASH/NetBeansProjects/CookBook_handler/data/receipe_data.csv' WITH (FORMAT csv);

COPY directions_table FROM '/Users/CASH/NetBeansProjects/CookBook_handler/data/directions_data.csv' WITH (FORMAT csv);


SELECT DISTINCT title FROM directions_table;
DELETE FROM reciepe_table WHERE title NOT IN (SELECT title FROM directions_table A);

ALTER TABLE reciepe_table ADD COLUMN directions text;

SELECT COUNT(1) FROM reciepe_table A,directions_table B WHERE A.title=B.title;


UPDATE 
reciepe_table t1 
SET 
  directions = t2.directions 
FROM 
   directions_table t2
  WHERE 
  t1.title = t2.title;

SELECT * FROM reciepe_table WHERE directions=null