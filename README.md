# Εσωτερικό Σύστημα - Οδηγίες Εκτέλεσης (Eclipse)
<p>1-File -> Import -> Git/Projects from Git -> Clone URI</p>
<p>2-Convert the project to Dynamic Web project (Project Facets -> Enable Faceted Project)</p>
<p>3-Convert the project to Maven project (Configure->Convert to Maven Project) & Update Project</p>

## Database
<p>CREATE TABLE students (
id int NOT NULL AUTO_INCREMENT,
name varchar(255) DEFAULT NULL,
department varchar(255) DEFAULT NULL,
semester int NOT NULL,
phone int NOT NULL,
email varchar(255) DEFAULT NULL,
locality BOOLEAN,
housing_years int NOT NULL,
application_sent BOOLEAN,
activation_status BOOLEAN,
points int,
ranking int,
application_approved BOOLEAN,
PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;
</p>

<p>
CREATE TABLE IF NOT EXISTS `user` (
 `username` varchar(50) NOT NULL,
 `password` varchar(100) NOT NULL,
 `enabled` tinyint(1) NOT NULL,
 PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
</p>

<p>
CREATE TABLE IF NOT EXISTS `authorities` (
 `username` varchar(50) NOT NULL,
 `authority` varchar(50) NOT NULL,
 PRIMARY KEY (`username`),
 UNIQUE KEY `ix_auth_username` (`username`,`authority`),
 CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  </p>
