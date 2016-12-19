INSERT INTO colors VALUES ('Red');
INSERT INTO colors VALUES ('Blue');
INSERT INTO colors VALUES ('Green');
INSERT INTO colors VALUES ('Black');
INSERT INTO colors VALUES ('White');
INSERT INTO colors VALUES ('Grey');
INSERT INTO colors VALUES ('Yellow');

INSERT INTO types VALUES ('New');
INSERT INTO types VALUES ('With mileage');

INSERT INTO wheels VALUES ('Right');
INSERT INTO wheels VALUES ('Left');

INSERT INTO gearboxes VALUES ('Automatic');
INSERT INTO gearboxes VALUES ('Manual');

-- VIEW
CREATE VIEW AllAutos
AS SELECT *
FROM auto;