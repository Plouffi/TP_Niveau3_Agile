/* Table passager contenant les infos d'un passager ayant pris un au moins un vol */
CREATE TABLE IF NOT EXISTS Passager
(
	numPasseport varchar(255) not null UNIQUE, /*N° de passport*/
  nom varchar(255) not null,
  prenom varchar(255) not null,
  adresse varchar(255) not null,
  noTelephone bigint(19) not null,
	primary key(numPasseport)
);

/* Table recensant la liste des rôles des membres du personnel (pilote, technicien) en 2 catégories*/
CREATE TABLE IF NOT EXISTS Role
(
	role varchar(255) not null UNIQUE,
	type ENUM('Navigant', 'NonNavigant'),
	primary key(role, type)
);

/* Table personnel contenant les infos d'un membre du personnel ainsi que son rôle et mot de passe*/
CREATE TABLE IF NOT EXISTS Personnel
(
	id int not null AUTO_INCREMENT, /*Identifiant du personnel unique*/
  nom varchar(255) not null,
  prenom varchar(255) not null,
  adresse varchar(255) not null,
  noTelephone bigint(19) not null,
	motDePasse varchar(255) not null, /*Le mot de passe sera hashé en bdd*/
  role varchar(255) not null, /*un trigger s'occupera de vérifier si le rôle est référencé*/
	type varchar(12) not null,
	foreign key (role) references Role(role),
	foreign key (type) references Role(type),
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
	primary key (pilote, type)
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
	numPasseport int not null,
  id int not null,
  dateDepart date not null,
	noPlace int not null,
	foreign key (numPasseport) references Passager(numPasseport),
	foreign key (id, dateDepart) references Depart(id, dateDepart),
	primary key(passager, id, dateDepart)
);

/* Table entre pilote et depart contenant le rapport */
CREATE TABLE IF NOT EXISTS RapportPilote
(
	idPilote int not null,
	idDepart int not null,
  dateDepart date not null,
	rapport text not null,
	foreign key (idPilote) references Pilote(id),
	foreign key (idDepart) references Depart(id),
  foreign key (dateDepart) references Depart(dateDepart),
	primary key(depart, pilote, dateDepart)
);

/* A chaque insertion d'un temps pour un type le trigger va modifier le temps de vol total */
DELIMITER $
CREATE TRIGGER insertTempsVolChecking AFTER INSERT
ON TempsVolType FOR EACH ROW
BEGIN
	UPDATE Pilote set nombreHeureTotal = (select nombreHeureTotal from Pilote where Pilote.id = NEW.pilote)+NEW.temps where Pilote.id = NEW.pilote;
END$
DELIMITER ;

/* A chaque modification d'un temps pour un type le trigger va modifier le temps de vol total */
DELIMITER $
CREATE TRIGGER updateTempsVolChecking AFTER UPDATE
ON TempsVolType FOR EACH ROW
BEGIN
	UPDATE Pilote set nombreHeureTotal = (select nombreHeureTotal from Pilote where Pilote.id = NEW.pilote)+NEW.temps-OLD.temps where Pilote.id = NEW.pilote;
END$
DELIMITER ;

/* Vérifie si le pilote ajouté se trouve dans le personnel */
DELIMITER $
CREATE TRIGGER insertPersonnelChecking BEFORE INSERT ON Pilote
FOR EACH ROW
BEGIN
  IF 'Pilote' NOT IN (SELECT role FROM  Personnel WHERE id = NEW.id) THEN
    CALL 'Insert not allowed'
  END IF;
END;
DELIMITER ;
