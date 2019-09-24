INSERT INTO dog( name, breed, size )
VALUES
( 'lady', 'husky', 'MD'),
( 'kobe', 'golden doodle', 'LG');

INSERT INTO keeper
( name, dog_id)
VALUES 
( 'sai', 2),
( 'chris', 1);

-- FOREIGN KEY ADDING; needed since keeper ids dont exist at top
--UPDATE dog 
--SET keeper_id = (select keeper_id from keeper 
--                where name='chris')
--where name='lady';
--UPDATE dog 
--SET keeper_id = (select keeper_id from keeper 
--                where name='sai')
--where name='koby';