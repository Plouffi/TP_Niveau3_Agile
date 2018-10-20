-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 20 oct. 2018 à 13:58
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

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
-- Structure de la table `avion`
--

DROP TABLE IF EXISTS `avion`;
CREATE TABLE IF NOT EXISTS `avion` (
  `immatriculation` varchar(255) NOT NULL,
  `capacite` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`immatriculation`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `avion`
--

INSERT INTO `avion` (`immatriculation`, `capacite`, `type`) VALUES
('1erz', 1, 'Airbus'),
('r24aOp1r75', 222222, 'Boeing');

-- --------------------------------------------------------

--
-- Structure de la table `depart`
--

DROP TABLE IF EXISTS `depart`;
CREATE TABLE IF NOT EXISTS `depart` (
  `id` int(11) NOT NULL,
  `dateDepart` date NOT NULL,
  PRIMARY KEY (`id`,`dateDepart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `departavion`
--

DROP TABLE IF EXISTS `departavion`;
CREATE TABLE IF NOT EXISTS `departavion` (
  `id` int(11) NOT NULL,
  `dateDepart` date NOT NULL,
  `immatriculation` varchar(255) NOT NULL,
  `qteCarburant` int(11) NOT NULL,
  PRIMARY KEY (`id`,`dateDepart`,`immatriculation`),
  KEY `immatriculation` (`immatriculation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `departpassager`
--

DROP TABLE IF EXISTS `departpassager`;
CREATE TABLE IF NOT EXISTS `departpassager` (
  `numPasseport` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `dateDepart` date NOT NULL,
  `noPlace` int(11) NOT NULL,
  PRIMARY KEY (`numPasseport`,`id`,`dateDepart`),
  KEY `id` (`id`,`dateDepart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `passager`
--

DROP TABLE IF EXISTS `passager`;
CREATE TABLE IF NOT EXISTS `passager` (
  `numPasseport` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `noTelephone` bigint(19) NOT NULL,
  PRIMARY KEY (`numPasseport`),
  UNIQUE KEY `numPasseport` (`numPasseport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
CREATE TABLE IF NOT EXISTS `personnel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `noTelephone` bigint(19) NOT NULL,
  `motDePasse` varchar(255) NOT NULL,
  `type` enum('navigant','nonnavigant') DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personnel`
--

INSERT INTO `personnel` (`id`, `nom`, `prenom`, `adresse`, `noTelephone`, `motDePasse`, `type`, `role`) VALUES
(3, 'erazere', 'ppp', 'rezarze', 21, 'mDP', 'nonnavigant', 'Service Technique'),
(4, 'reza', 'reaz', 'rezar', 2, 'popo', 'navigant', 'Pilote'),
(6, 'nom', 'prenom', 'adresse', 0, 'mdp', 'nonnavigant', 'Service Technique');

-- --------------------------------------------------------

--
-- Structure de la table `pilote`
--

DROP TABLE IF EXISTS `pilote`;
CREATE TABLE IF NOT EXISTS `pilote` (
  `id` int(11) NOT NULL,
  `nombreHeureTotal` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `rapportpilote`
--

DROP TABLE IF EXISTS `rapportpilote`;
CREATE TABLE IF NOT EXISTS `rapportpilote` (
  `idPilote` int(11) NOT NULL,
  `idDepart` int(11) NOT NULL,
  `dateDepart` date NOT NULL,
  `rapport` text NOT NULL,
  PRIMARY KEY (`idDepart`,`idPilote`,`dateDepart`),
  KEY `idPilote` (`idPilote`),
  KEY `dateDepart` (`dateDepart`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `role` varchar(255) NOT NULL,
  `type` enum('navigant','nonnavigant') NOT NULL,
  PRIMARY KEY (`role`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`role`, `type`) VALUES
('Hotesse', 'navigant'),
('Pilote', 'navigant'),
('Service Gestionnaire', 'nonnavigant'),
('Service Personnel', 'nonnavigant'),
('Service Technique', 'nonnavigant');

-- --------------------------------------------------------

--
-- Structure de la table `tempsvoltype`
--

DROP TABLE IF EXISTS `tempsvoltype`;
CREATE TABLE IF NOT EXISTS `tempsvoltype` (
  `id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `nombreHeure` time NOT NULL,
  PRIMARY KEY (`id`,`type`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déclencheurs `tempsvoltype`
--
DROP TRIGGER IF EXISTS `insertTempsVolChecking`;
DELIMITER $$
CREATE TRIGGER `insertTempsVolChecking` AFTER INSERT ON `tempsvoltype` FOR EACH ROW BEGIN
	UPDATE Pilote set nombreHeureTotal = (select nombreHeureTotal from Pilote where Pilote.id = NEW.id)+NEW.nombreHeure where Pilote.id = NEW.id;
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `updateTempsVolChecking`;
DELIMITER $$
CREATE TRIGGER `updateTempsVolChecking` AFTER UPDATE ON `tempsvoltype` FOR EACH ROW BEGIN
	UPDATE Pilote set nombreHeureTotal = (select nombreHeureTotal from Pilote where Pilote.id = NEW.id)+NEW.nombreHeure-OLD.nombreHeure where Pilote.id = NEW.id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `troncon`
--

DROP TABLE IF EXISTS `troncon`;
CREATE TABLE IF NOT EXISTS `troncon` (
  `villeDepart` varchar(255) NOT NULL,
  `villeArrivee` varchar(255) NOT NULL,
  `distance` int(11) NOT NULL,
  PRIMARY KEY (`villeDepart`,`villeArrivee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `typeavion`
--

DROP TABLE IF EXISTS `typeavion`;
CREATE TABLE IF NOT EXISTS `typeavion` (
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typeavion`
--

INSERT INTO `typeavion` (`type`) VALUES
('Airbus'),
('Boeing');

-- --------------------------------------------------------

--
-- Structure de la table `vol`
--

DROP TABLE IF EXISTS `vol`;
CREATE TABLE IF NOT EXISTS `vol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `frequence` int(11) NOT NULL,
  `uniteFrequence` enum('heure','jour','semaine','mois','an') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `voltroncon`
--

DROP TABLE IF EXISTS `voltroncon`;
CREATE TABLE IF NOT EXISTS `voltroncon` (
  `id` int(11) NOT NULL,
  `villeDepart` varchar(255) NOT NULL,
  `villeArrivee` varchar(255) NOT NULL,
  `heureDepart` int(11) NOT NULL,
  `heureArrivee` int(11) NOT NULL,
  PRIMARY KEY (`id`,`villeDepart`,`villeArrivee`),
  KEY `villeDepart` (`villeDepart`,`villeArrivee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
