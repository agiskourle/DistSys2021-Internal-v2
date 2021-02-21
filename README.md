# Εσωτερικό Σύστημα - Οδηγίες Εκτέλεσης (Eclipse)
<p>1-File -> Import -> Git/Projects from Git -> Clone URI</p>
<p>2-Convert the project to Dynamic Web project (Project Facets -> Enable Faceted Project)</p>
<p>3-Convert the project to Maven project (Configure->Convert to Maven Project) & Update Project</p>
# Βάση Δεδομένων
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
) DEFAULT CHARSET=utf8;</p>
