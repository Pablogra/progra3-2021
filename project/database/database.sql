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




INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Felipe','Felipe Camacho','f@ulatina.com','asdf',true, true);

INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Alberto','Alberto Abarca','A@ulatina.com','asdf',true, false);

INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Pablo','Pablo Granados','p@ulatina.com','asdf',true, false);

INSERT INTO User (username, fullname, email,password,status, isAdmin) VALUES ('Melany','Melany Vasquez','m@ulatina.com','asdf',true, true);