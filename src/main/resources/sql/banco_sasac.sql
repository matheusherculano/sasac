-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sasac
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sasac
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sasac` DEFAULT CHARACTER SET latin1 ;
USE `sasac` ;

-- -----------------------------------------------------
-- Table `sasac`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sasac`.`perfil` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `perfil` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sasac`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sasac`.`usuario` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome_usuario` VARCHAR(150) NULL DEFAULT NULL,
  `perfil_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_3gsqha3puu1ccw81jefi4j71t` (`perfil_id` ASC),
  CONSTRAINT `FK_3gsqha3puu1ccw81jefi4j71t`
    FOREIGN KEY (`perfil_id`)
    REFERENCES `sasac`.`perfil` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sasac`.`repeticao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sasac`.`repeticao` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `repeticao` VARCHAR(30) NOT NULL,
  `qtd_repeticoes` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sasac`.`avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sasac`.`avaliacao` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(300) NULL,
  `dt_disponibilidade` DATE NOT NULL,
  `publicado` BIT(1) NOT NULL,
  `txt_resposta_negativa` VARCHAR(40) NOT NULL,
  `txt_resposta_neutra` VARCHAR(40) NOT NULL,
  `txt_resposta_postivia` VARCHAR(40) NOT NULL,
  `titulo` VARCHAR(40) NULL DEFAULT NULL,
  `repeticao_id` BIGINT(20) NULL DEFAULT NULL,
  `usuario_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_k5x9dinkf85uuv9dkrj02xkrs` (`repeticao_id` ASC),
  INDEX `FK_rq8a8m2aw2t638et4v723dhl` (`usuario_id` ASC),
  CONSTRAINT `FK_rq8a8m2aw2t638et4v723dhl`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `sasac`.`usuario` (`id`),
  CONSTRAINT `FK_k5x9dinkf85uuv9dkrj02xkrs`
    FOREIGN KEY (`repeticao_id`)
    REFERENCES `sasac`.`repeticao` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sasac`.`periodo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sasac`.`periodo` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `dt_publicacao` DATE NOT NULL,
  `respostas_negativas` INT(11) NULL DEFAULT NULL,
  `respostas_neutras` INT(11) NULL DEFAULT NULL,
  `respostas_positivas` INT(11) NULL DEFAULT NULL,
  `avaliacao_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_2iiemlvovprnvl8u8saobw2y2` (`avaliacao_id` ASC),
  CONSTRAINT `FK_2iiemlvovprnvl8u8saobw2y2`
    FOREIGN KEY (`avaliacao_id`)
    REFERENCES `sasac`.`avaliacao` (`id`)
    ON DELETE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sasac`.`usuario_periodo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sasac`.`usuario_periodo` (
  `usuario_id` BIGINT(20) NOT NULL,
  `periodo_id` BIGINT(20) NOT NULL,
  INDEX `FK_hso4cywpwt5ojweuuyslijtya` (`periodo_id` ASC),
  INDEX `FK_s579q9li7xovtagejy3kk2ebg` (`usuario_id` ASC),
  CONSTRAINT `FK_s579q9li7xovtagejy3kk2ebg`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `sasac`.`usuario` (`id`)
    ON DELETE RESTRICT,
  CONSTRAINT `FK_hso4cywpwt5ojweuuyslijtya`
    FOREIGN KEY (`periodo_id`)
    REFERENCES `sasac`.`periodo` (`id`)
    ON DELETE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
