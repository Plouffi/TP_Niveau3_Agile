/* Table passager contenant les infos d'un passager ayant pris un au moins un vol */
CREATE TABLE IF NOT EXISTS Passager
(
	numPasseport varchar(255) not null UNIQUE, /*N° de passport*/
  nom varchar(255) not null,
  prenom varchar(255) not null,
  adresse varchar(255) not null,
  noTelephone varchar(19) not null,
	primary key(numPasseport)
);

/* Tables recensant la liste des rôles des membres du personnel (pilote, technicien) en 2 catégories*/
CREATE TABLE IF NOT EXISTS Role
(
	role varchar(255) not null UNIQUE,
	type ENUM('Navigant', 'NonNavigant'),
	primary key(role)
);

/* Table personnel contenant les infos d'un membre du personnel ainsi que son rôle et mot de passe*/
CREATE TABLE IF NOT EXISTS Personnel
(
	id int not null AUTO_INCREMENT, /*Identifiant du personnel unique*/
  nom varchar(255) not null,
  prenom varchar(255) not null,
  adresse varchar(255) not null,
  noTelephone varchar(19) not null,
	motDePasse varchar(255) not null, /*Le mot de passe sera hashé en bdd*/
  role varchar(255) not null,
	foreign key (role) references Role(role),
	primary key(id)
);
/*Table pilote qui stock le nombre total d'heure de vol*/
CREATE TABLE IF NOT EXISTS Pilote
(
	id int not null,
	nombreHeureTotal time not null,
	/* ATTENTION : '-838:59:59' to '838:59:59'*/
	foreign key (id) references Personnel(id),
	primary key(id)
);

/* Tables des avions et de leurs infos */
CREATE TABLE IF NOT EXISTS TypeAvion
(
	type varchar(255) not null,
	primary key(type)
);

CREATE TABLE IF NOT EXISTS Avion
(
	immatriculation varchar(255) not null,
	capacite int not null,
	type varchar(255) not null,
	foreign key (type) references TypeAvion(type),
	primary key(immatriculation)
);

/* Temps de vol par type par pilote */
CREATE TABLE IF NOT EXISTS TempsVolType
(
	id int not null,
	type varchar(255) not null,
	nombreHeure time not null,
	/* ATTENTION : '-838:59:59' to '838:59:59'*/
	foreign key (id) references Pilote(id),
	foreign key (type) references TypeAvion(type),
	primary key (id, type)
);

/*Tables des vols stockant leurs trajets, leurs dates d'arrivé/de départ, etc...*/
CREATE TABLE IF NOT EXISTS Troncon
(
	villeDepart varchar(255) not null,
	villeArrivee varchar(255) not null,
	distance int not null,
	primary key (villeDepart, villeArrivee)
);

CREATE TABLE IF NOT EXISTS Vol
(
	id int not null AUTO_INCREMENT,
  /* la fréquence est stockée de la manière suivante: X par unitee*/
	frequence int not null,
  uniteFrequence ENUM('heure', 'jour', 'semaine', 'mois', 'an'),
	primary key (id)
);


CREATE TABLE IF NOT EXISTS VolTroncon
(
	id int not null,
  villeDepart varchar(255) not null,
	villeArrivee varchar(255) not null,
	heureDepart int not null,
	heureArrivee int not null,
	foreign key (id) references Vol(id),
	foreign key (villeDepart, villeArrivee) references Troncon(villeDepart, villeArrivee),
	primary key (id, villeDepart, villeArrivee)
);

/*Tables des départs qui stockent quand les vols ont lieu et qui embarque */
CREATE TABLE IF NOT EXISTS Depart
(
	id int not null,
	dateDepart date not null,
	foreign key (id) references Vol(id),
	primary key(id, dateDepart)
);

CREATE TABLE IF NOT EXISTS DepartAvion
(
	id int not null,
  dateDepart date not null,
	immatriculation varchar(255) not null,
	qteCarburant int not null,
	foreign key (id, dateDepart) references Depart(id, dateDepart),
	foreign key (immatriculation) references Avion(immatriculation),
	primary key(id, dateDepart, immatriculation)
);

CREATE TABLE IF NOT EXISTS DepartPassager
(
	numPasseport varchar(255) not null,
	id int not null,
	dateDepart date not null,
	noPlace int not null,
	foreign key (numPasseport) references Passager(numPasseport),
	foreign key (id, dateDepart) references Depart(id, dateDepart),
	primary key(numPasseport, id, dateDepart)
);

/* Table entre pilote et depart contenant le rapport */
CREATE TABLE IF NOT EXISTS RapportPilote
(
	idPilote int not null,
	idDepart int not null,
  dateDepart date not null,
	rapport text not null,
	foreign key (idPilote) references Pilote(id),
	foreign key (idDepart, dateDepart) references Depart(id, dateDepart),
	primary key(idDepart, idPilote, dateDepart)
);

/* A chaque insertion d'un temps pour un type le trigger va modifier le temps de vol total */
DELIMITER $
CREATE TRIGGER insertTempsVolChecking AFTER INSERT
ON TempsVolType FOR EACH ROW
BEGIN
	UPDATE Pilote set nombreHeureTotal = (select nombreHeureTotal from Pilote where Pilote.id = NEW.id)+NEW.nombreHeure where Pilote.id = NEW.id;
END$
DELIMITER ;

/* A chaque modification d'un temps pour un type le trigger va modifier le temps de vol total */
DELIMITER $
CREATE TRIGGER updateTempsVolChecking AFTER UPDATE
ON TempsVolType FOR EACH ROW
BEGIN
	UPDATE Pilote set nombreHeureTotal = (select nombreHeureTotal from Pilote where Pilote.id = NEW.id)+NEW.nombreHeure-OLD.nombreHeure where Pilote.id = NEW.id;
END$
DELIMITER ;

/* Ajoute le pilote */
DELIMITER $
CREATE TRIGGER insertPersonnelChecking BEFORE INSERT ON Personnel
FOR EACH ROW
BEGIN
  INSERT INTO Pilote VALUES(New.id, "00:00:00")
END;
DELIMITER ;
