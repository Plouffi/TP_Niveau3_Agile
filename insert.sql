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
