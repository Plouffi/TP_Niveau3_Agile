-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : tpavion2.cuxgpqum2bql.us-east-2.rds.amazonaws.com:3306
-- Généré le :  sam. 10 nov. 2018 à 18:08
-- Version du serveur :  5.6.41-log
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tpavion`
--

-- --------------------------------------------------------

--
-- Structure de la table `Avion`
--

DROP TABLE IF EXISTS `Avion`;
CREATE TABLE IF NOT EXISTS `Avion` (
  `immatriculation` varchar(255) NOT NULL,
  `capacite` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`immatriculation`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `Avion`
--

INSERT INTO `Avion` (`immatriculation`, `capacite`, `type`) VALUES
('A1', 300, 'Airbus'),
('B1', 500, 'Boeing'),
('B2', 500, 'Boeing');

-- --------------------------------------------------------

--
-- Structure de la table `Depart`
--

DROP TABLE IF EXISTS `Depart`;
CREATE TABLE IF NOT EXISTS `Depart` (
  `id` int(11) NOT NULL,
  `dateDepart` date NOT NULL,
  PRIMARY KEY (`id`,`dateDepart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `Depart`
--

INSERT INTO `Depart` (`id`, `dateDepart`) VALUES
(1, '2018-11-03'),
(1, '2018-11-13');

-- --------------------------------------------------------

--
-- Structure de la table `DepartAvion`
--

DROP TABLE IF EXISTS `DepartAvion`;
CREATE TABLE IF NOT EXISTS `DepartAvion` (
  `id` int(11) NOT NULL,
  `dateDepart` date NOT NULL,
  `immatriculation` varchar(255) NOT NULL,
  `qteCarburant` int(11) NOT NULL,
  PRIMARY KEY (`id`,`dateDepart`,`immatriculation`),
  KEY `immatriculation` (`immatriculation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `DepartAvion`
--

INSERT INTO `DepartAvion` (`id`, `dateDepart`, `immatriculation`, `qteCarburant`) VALUES
(1, '2018-11-03', 'B2', 8);

-- --------------------------------------------------------

--
-- Structure de la table `DepartPassager`
--

DROP TABLE IF EXISTS `DepartPassager`;
CREATE TABLE IF NOT EXISTS `DepartPassager` (
  `numPasseport` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
  `dateDepart` date NOT NULL,
  `noPlace` int(11) NOT NULL,
  PRIMARY KEY (`numPasseport`,`id`,`dateDepart`),
  KEY `id` (`id`,`dateDepart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `DepartPassager`
--

INSERT INTO `DepartPassager` (`numPasseport`, `id`, `dateDepart`, `noPlace`) VALUES
('2', 1, '2018-11-03', 1);

-- --------------------------------------------------------

--
-- Structure de la table `Passager`
--

DROP TABLE IF EXISTS `Passager`;
CREATE TABLE IF NOT EXISTS `Passager` (
  `numPasseport` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `noTelephone` varchar(19) NOT NULL,
  PRIMARY KEY (`numPasseport`),
  UNIQUE KEY `numPasseport` (`numPasseport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `Passager`
--

INSERT INTO `Passager` (`numPasseport`, `nom`, `prenom`, `adresse`, `noTelephone`) VALUES
('0', '0', '0', '0', '0'),
('1234', 'passager1', 'passager1', 'passager1', '0000000000'),
('2', '2', '2', '2', '2'),
('5678', 'passager2', 'passager2', 'passager2', '0000000000');

-- --------------------------------------------------------

--
-- Structure de la table `Personnel`
--

DROP TABLE IF EXISTS `Personnel`;
CREATE TABLE IF NOT EXISTS `Personnel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `noTelephone` varchar(19) NOT NULL,
  `motDePasse` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `Personnel`
--

INSERT INTO `Personnel` (`id`, `nom`, `prenom`, `adresse`, `noTelephone`, `motDePasse`, `role`) VALUES
(1, 'Gestionnaire', 'Gestionnaire', 'Gestionnaire', '0000000000', '', 'Service Gestionnaire'),
(2, 'Technique', 'Technique', 'Technique', '0000000000', '', 'Service Technique'),
(3, 'Personnel', 'Personnel', 'Personnel', '0000000000', '', 'Service Personnel'),
(4, 'Pilote', 'Pilote', 'Pilote', '0000000000', '', 'Pilote'),
(5, 'lp', 'rei', 'chez moi', '0646877828', 'rei', 'Pilote');

--
-- Déclencheurs `Personnel`
--
DROP TRIGGER IF EXISTS `insertPersonnelChecking`;
DELIMITER $$
CREATE TRIGGER `insertPersonnelChecking` AFTER INSERT ON `Personnel` FOR EACH ROW BEGIN
	IF new.role = "Pilote" THEN
  	INSERT INTO Pilote VALUES(New.id, "00:00:00");
	END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `Pilote`
--

DROP TABLE IF EXISTS `Pilote`;
CREATE TABLE IF NOT EXISTS `Pilote` (
  `id` int(11) NOT NULL,
  `nombreHeureTotal` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `Pilote`
--

INSERT INTO `Pilote` (`id`, `nombreHeureTotal`) VALUES
(4, '00:00:00'),
(5, '00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `RapportPilote`
--

DROP TABLE IF EXISTS `RapportPilote`;
CREATE TABLE IF NOT EXISTS `RapportPilote` (
  `idPilote` int(11) NOT NULL,
  `idDepart` int(11) NOT NULL,
  `dateDepart` date NOT NULL,
  `rapport` text NOT NULL,
  PRIMARY KEY (`idDepart`,`idPilote`,`dateDepart`),
  KEY `idPilote` (`idPilote`),
  KEY `idDepart` (`idDepart`,`dateDepart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Role`
--

DROP TABLE IF EXISTS `Role`;
CREATE TABLE IF NOT EXISTS `Role` (
  `role` varchar(255) NOT NULL,
  `type` enum('Navigant','NonNavigant') DEFAULT NULL,
  PRIMARY KEY (`role`),
  UNIQUE KEY `role` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `Role`
--

INSERT INTO `Role` (`role`, `type`) VALUES
('Pilote', 'Navigant'),
('Service Gestionnaire', 'NonNavigant'),
('Service Personnel', 'NonNavigant'),
('Service Technique', 'NonNavigant');

-- --------------------------------------------------------

--
-- Structure de la table `TempsVolType`
--

DROP TABLE IF EXISTS `TempsVolType`;
CREATE TABLE IF NOT EXISTS `TempsVolType` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `nombreHeure` time NOT NULL,
  PRIMARY KEY (`id`,`type`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déclencheurs `TempsVolType`
--
DROP TRIGGER IF EXISTS `insertTempsVolChecking`;
DELIMITER $$
CREATE TRIGGER `insertTempsVolChecking` AFTER INSERT ON `TempsVolType` FOR EACH ROW BEGIN
	UPDATE Pilote set nombreHeureTotal = (select nombreHeureTotal from (select * from Pilote) as p2 where p2.id = NEW.id)+NEW.nombreHeure where Pilote.id = NEW.id;
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `updateTempsVolChecking`;
DELIMITER $$
CREATE TRIGGER `updateTempsVolChecking` AFTER UPDATE ON `TempsVolType` FOR EACH ROW BEGIN
	UPDATE Pilote set nombreHeureTotal = (select nombreHeureTotal from (select * from Pilote) as p2 where p2.id = NEW.id)+NEW.nombreHeure where Pilote.id = NEW.id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `Troncon`
--

DROP TABLE IF EXISTS `Troncon`;
CREATE TABLE IF NOT EXISTS `Troncon` (
  `villeDepart` varchar(255) NOT NULL,
  `villeArrivee` varchar(255) NOT NULL,
  `distance` int(11) NOT NULL,
  PRIMARY KEY (`villeDepart`,`villeArrivee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `Troncon`
--

INSERT INTO `Troncon` (`villeDepart`, `villeArrivee`, `distance`) VALUES
('Paris', 'Grenoble', 350),
('Paris', 'La Rochelle', 400);

-- --------------------------------------------------------

--
-- Structure de la table `TypeAvion`
--

DROP TABLE IF EXISTS `TypeAvion`;
CREATE TABLE IF NOT EXISTS `TypeAvion` (
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `TypeAvion`
--

INSERT INTO `TypeAvion` (`type`) VALUES
('Airbus'),
('Boeing'),
('Stinson');

-- --------------------------------------------------------

--
-- Structure de la table `Vol`
--

DROP TABLE IF EXISTS `Vol`;
CREATE TABLE IF NOT EXISTS `Vol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `frequence` int(11) NOT NULL,
  `uniteFrequence` enum('heure','jour','semaine','mois','an') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `Vol`
--

INSERT INTO `Vol` (`id`, `frequence`, `uniteFrequence`) VALUES
(1, 2, 'jour'),
(2, 3, 'semaine'),
(3, 2, 'heure'),
(5, 2, 'heure');

-- --------------------------------------------------------

--
-- Structure de la table `VolTroncon`
--

DROP TABLE IF EXISTS `VolTroncon`;
CREATE TABLE IF NOT EXISTS `VolTroncon` (
  `id` int(11) NOT NULL,
  `villeDepart` varchar(255) NOT NULL,
  `villeArrivee` varchar(255) NOT NULL,
  `heureDepart` time(6) NOT NULL,
  `heureArrivee` time(6) NOT NULL,
  PRIMARY KEY (`id`,`villeDepart`,`villeArrivee`),
  KEY `villeDepart` (`villeDepart`,`villeArrivee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `VolTroncon`
--

INSERT INTO `VolTroncon` (`id`, `villeDepart`, `villeArrivee`, `heureDepart`, `heureArrivee`) VALUES
(1, 'Paris', 'Grenoble', '12:00:00.000000', '13:00:00.000000'),
(1, 'Paris', 'La Rochelle', '12:00:00.000000', '13:00:00.000000');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Avion`
--
ALTER TABLE `Avion`
  ADD CONSTRAINT `Avion_ibfk_1` FOREIGN KEY (`type`) REFERENCES `TypeAvion` (`type`);

--
-- Contraintes pour la table `Depart`
--
ALTER TABLE `Depart`
  ADD CONSTRAINT `Depart_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Vol` (`id`);

--
-- Contraintes pour la table `DepartAvion`
--
ALTER TABLE `DepartAvion`
  ADD CONSTRAINT `DepartAvion_ibfk_1` FOREIGN KEY (`id`,`dateDepart`) REFERENCES `Depart` (`id`, `dateDepart`),
  ADD CONSTRAINT `DepartAvion_ibfk_2` FOREIGN KEY (`immatriculation`) REFERENCES `Avion` (`immatriculation`);

--
-- Contraintes pour la table `DepartPassager`
--
ALTER TABLE `DepartPassager`
  ADD CONSTRAINT `DepartPassager_ibfk_1` FOREIGN KEY (`numPasseport`) REFERENCES `Passager` (`numPasseport`),
  ADD CONSTRAINT `DepartPassager_ibfk_2` FOREIGN KEY (`id`,`dateDepart`) REFERENCES `Depart` (`id`, `dateDepart`);

--
-- Contraintes pour la table `Personnel`
--
ALTER TABLE `Personnel`
  ADD CONSTRAINT `Personnel_ibfk_1` FOREIGN KEY (`role`) REFERENCES `Role` (`role`);

--
-- Contraintes pour la table `Pilote`
--
ALTER TABLE `Pilote`
  ADD CONSTRAINT `Pilote_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Personnel` (`id`);

--
-- Contraintes pour la table `RapportPilote`
--
ALTER TABLE `RapportPilote`
  ADD CONSTRAINT `RapportPilote_ibfk_1` FOREIGN KEY (`idPilote`) REFERENCES `Pilote` (`id`),
  ADD CONSTRAINT `RapportPilote_ibfk_2` FOREIGN KEY (`idDepart`,`dateDepart`) REFERENCES `Depart` (`id`, `dateDepart`);

--
-- Contraintes pour la table `TempsVolType`
--
ALTER TABLE `TempsVolType`
  ADD CONSTRAINT `TempsVolType_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Pilote` (`id`),
  ADD CONSTRAINT `TempsVolType_ibfk_2` FOREIGN KEY (`type`) REFERENCES `TypeAvion` (`type`);

--
-- Contraintes pour la table `VolTroncon`
--
ALTER TABLE `VolTroncon`
  ADD CONSTRAINT `VolTroncon_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Vol` (`id`),
  ADD CONSTRAINT `VolTroncon_ibfk_2` FOREIGN KEY (`villeDepart`,`villeArrivee`) REFERENCES `Troncon` (`villeDepart`, `villeArrivee`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
