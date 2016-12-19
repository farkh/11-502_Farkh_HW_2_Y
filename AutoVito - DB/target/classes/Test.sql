CREATE function registration_insert (loginI varchar, passwordI VARCHAR, nameI VARCHAR, surnameI VARCHAR,
                                     cityI VARCHAR, streetI VARCHAR, houseI VARCHAR, phoneI VARCHAR)
returns null
as $$
DECLARE
  id INTEGER;
begin

  id := insert into users values (DEFAULT, loginI, passwordI) returning id;
  INSERT INTO customers VALUES (id, nameI, surnameI, cityI, streetI, houseI, phoneI);

end;
$$ LANGUAGE plpgsql;