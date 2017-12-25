# Spring-JdbcTemplate-Employee-CRUD

this is example for spring with jdbc template for employee crud operations.

database schema;
CREATE TABLE `Employee` (
  `empid` int(11) NOT NULL,
  `empaddress` varchar(255) DEFAULT NULL,
  `empAge` int(11) DEFAULT NULL,
  `empname` varchar(255) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

properties file;
database.driver=com.mysql.jdbc.Driver
database.url=jdbc:mysql://localhost:3306/acs_abd
database.user=root
database.password=

injections ; DataSource is injected to JdbcTemplate, JdbcTemplate is injected to Dao object in implementation.

hope this will help you; happy coding;
