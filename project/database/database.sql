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
  `idActivity` INT NOT NULL AUTO_INCREMENT,
  `idActivityType` INT NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `Title` VARCHAR(255) NOT NULL,
  `Date` DATETIME NOT NULL,
  `points` INT NOT NULL,
  PRIMARY KEY (`idActivity`),
  INDEX `fkActivityType_idx` (`idActivityType` ASC) VISIBLE,
  CONSTRAINT `fkActivityType`
    FOREIGN KEY (`idActivityType`)
    REFERENCES `activitytype` (`idActivityType`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `score` (
  `idScore` int NOT NULL AUTO_INCREMENT,
  `idActivity` int NOT NULL,
  `userID` int NOT NULL,
  `date` datetime NOT NULL,
  `points` int NOT NULL,
  PRIMARY KEY (`idScore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Felipe','Felipe Camacho','f@ulatina.com','asdf',true, true);

INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Alberto','Alberto Abarca','A@ulatina.com','asdf',true, false);

INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Pablo','Pablo Granados','p@ulatina.com','asdf',true, false);

INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Melany','Melany Vasquez','m@ulatina.com','asdf',true, true);