USE
`employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users`
(
    `username` varchar(50) NOT NULL,
    `password` varchar(68) NOT NULL,
    `enabled`  tinyint     NOT NULL,
    PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at:  https://www.bcryptcalculator.com/encode
--
-- Default passwords here are: fun123
--

INSERT INTO `users`
VALUES (''john'', ''{bcrypt}$2a$10$ljB8hQ0Slc7AQhRb50u4MuQpfpiQNL3psYEtORGXzWL92Zx.X69ai'', 1),
       (''mary'', ''{bcrypt}$2a$10$tsoabMbZvLhmJshjBYWXO.ZNARcJbEKNmaBiG2sI3Bjaj0jz0c5s2'', 1),
       (''susan'', ''{bcrypt}$2a$10$gmMm/QeUGwckd4GHzfKWeeGI9XpdZjTXnoWd/PHpMnq7t79I4nnjK'', 1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities`
(
    `username`  varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES (''john'', ''ROLE_EMPLOYEE''),
       (''mary'', ''ROLE_EMPLOYEE''),
       (''mary'', ''ROLE_MANAGER''),
       (''susan'', ''ROLE_EMPLOYEE''),
       (''susan'', ''ROLE_MANAGER''),
       (''susan'', ''ROLE_ADMIN'');


