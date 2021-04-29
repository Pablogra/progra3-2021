 CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `fullname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `status` tinyint DEFAULT NULL,
  `isAdmin` tinyint DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



CREATE TABLE `activitytype` (
  `idActivityType` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Points` int NOT NULL,
  PRIMARY KEY (`idActivityType`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE `activity` (
  `idActivity` int NOT NULL AUTO_INCREMENT,
  `idActivityType` int NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Points` int NOT NULL,
  `Description` varchar(255) NOT NULL,
  PRIMARY KEY (`idActivity`),
  KEY `fkActivityType_idx` (`idActivityType`),
  CONSTRAINT `fkActivityType` FOREIGN KEY (`idActivityType`) REFERENCES `activitytype` (`idActivityType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `score` (
  `idScore` int NOT NULL AUTO_INCREMENT,
  `idActivity` int NOT NULL,
  `userID` int NOT NULL,
  `date` datetime NOT NULL,
  `points` int NOT NULL,
  PRIMARY KEY (`idScore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `progra3db`.`email` (
  `idemail` INT NOT NULL AUTO_INCREMENT,
  `emailName` VARCHAR(255) NOT NULL,
  `Subject` VARCHAR(255) NOT NULL,
  `Message` VARCHAR(4096) NOT NULL,
  `template` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idemail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Felipe','Felipe Camacho','f@ulatina.com','asdf',true, true);

INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Alberto','Alberto Abarca','A@ulatina.com','asdf',true, false);

INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Pablo','Pablo Granados','p@ulatina.com','asdf',true, false);

INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Melany','Melany Vasquez','m@ulatina.com','asdf',true, true);


INSERT INTO `progra3db`.`email`
(`emailName`,
`Subject`,
`Message`,
`Template`)
VALUES
('Welcome Email', '', '', 'WelcomeUser.html');


INSERT INTO `progra3db`.`email`
(`emailName`,
`Subject`,
`Message`,
`Template`)
VALUES
('New Activity Created', '', '', 'NewActivity.html');

INSERT INTO `progra3db`.`email`
(`emailName`,
`Subject`,
`Message`,
`Template`)
VALUES
('Scoreboard Updates', '', '', 'ScoreBoard.html');

