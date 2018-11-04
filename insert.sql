/* Insertion des rôles */
INSERT INTO Role VALUES ("Service Technique","NonNavigant");
INSERT INTO Role VALUES ("Service Personnel","NonNavigant");
INSERT INTO Role VALUES ("Service Gestionnaire","NonNavigant");
INSERT INTO Role VALUES ("Pilote","Navigant");

/* Inerstion du personnel */
INSERT INTO Personnel (nom, prenom, adresse, noTelephone, motDePasse, role) VALUES ("Gestionnaire","Gestionnaire","Gestionnaire","0000000000","","Service Gestionnaire");
INSERT INTO Personnel (nom, prenom, adresse, noTelephone, motDePasse, role) VALUES ("Technique","Technique","Technique","0000000000","","Service Technique");
INSERT INTO Personnel (nom, prenom, adresse, noTelephone, motDePasse, role) VALUES ("Personnel","Personnel","Personnel","0000000000","","Service Personnel");
INSERT INTO Personnel (nom, prenom, adresse, noTelephone, motDePasse, role) VALUES ("Pilote","Pilote","Pilote","0000000000","","Pilote");

/* Insertion des passagers*/
INSERT INTO Passager VALUES (1234, "passager1", "passager1", "passager1", "0000000000");
INSERT INTO Passager VALUES (5678, "passager2", "passager2", "passager2", "0000000000");

/* Insertion des avions */
INSERT INTO TypeAvion VALUES("Boeing");
INSERT INTO TypeAvion VALUES("Airbus");
INSERT INTO TypeAvion VALUES("Stinson");

INSERT INTO Avion VALUES("B1",500,"Boeing");
INSERT INTO Avion VALUES("B2",500,"Boeing");
INSERT INTO Avion VALUES("A1",300,"Airbus");

/*Insertion des vols*/
INSERT INTO Vol(frequence, uniteFrequence) VALUES ("2", "jour");
INSERT INTO Troncon VALUES ("Paris", "Grenoble", 350);
INSERT INTO VolTroncon VALUES(1, "Paris", "Grenoble", "12:00:00", "13:00:00");

/*Insertion des départs*/
INSERT INTO Depart VALUES (1, "2018-11-12");
INSERT INTO DepartAvion VALUES (1, "2018-11-12", "B1", 1000);
