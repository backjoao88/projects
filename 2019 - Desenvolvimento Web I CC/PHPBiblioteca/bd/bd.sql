-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bib
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bib
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bib` DEFAULT CHARACTER SET utf8 ;
USE `bib` ;
-- -----------------------------------------------------
-- Table `bib`.`livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bib`.`livro` (
  `livro_id` INT NOT NULL AUTO_INCREMENT,
  `livro_nome` VARCHAR(45) NULL,
  `livro_isbn` VARCHAR(45) NULL,
  `livro_edicao` VARCHAR(45) NULL,
  `livro_data_publicacao` DATE NULL,
  `livro_autor` VARCHAR(45) NULL,
  PRIMARY KEY (`livro_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bib`.`bibliotecario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bib`.`bibliotecario` (
  `bibliotecario_id` INT NOT NULL AUTO_INCREMENT,
  `bibliotecario_nome` VARCHAR(45) NULL,
  `bibliotecario_cpf` VARCHAR(45) NULL,
  `bibliotecario_login` VARCHAR(45) NULL,
  `bibliotecario_senha` VARCHAR(45) NULL,
  PRIMARY KEY (`bibliotecario_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `bib`.`emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bib`.`emprestimo` (
  `emprestimo_id` INT NOT NULL AUTO_INCREMENT,
  `emprestimo_data_entrega` DATE NULL,
  `emprestimo_data_devolucao` DATE NULL,
  `emprestimo_bibliotecario_id` INT NOT NULL,
  PRIMARY KEY (`emprestimo_id`),
  INDEX `fk_emprestimo_bibliotecario1_idx` (`emprestimo_bibliotecario_id` ASC),
  CONSTRAINT `fk_emprestimo_bibliotecario1`
    FOREIGN KEY (`emprestimo_bibliotecario_id`)
    REFERENCES `bib`.`bibliotecario` (`bibliotecario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bib`.`livro_emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bib`.`livro_emprestimo` (
  `livro_emprestimo_livro_id` INT NOT NULL,
  `livro_emprestimo_emprestimo_id` INT NOT NULL,
  PRIMARY KEY (`livro_emprestimo_livro_id`, `livro_emprestimo_emprestimo_id`),
  INDEX `fk_livro_has_emprestimo_emprestimo1_idx` (`livro_emprestimo_emprestimo_id` ASC),
  INDEX `fk_livro_has_emprestimo_livro1_idx` (`livro_emprestimo_livro_id` ASC),
  CONSTRAINT `fk_livro_has_emprestimo_livro1`
    FOREIGN KEY (`livro_emprestimo_livro_id`)
    REFERENCES `bib`.`livro` (`livro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livro_has_emprestimo_emprestimo1`
    FOREIGN KEY (`livro_emprestimo_emprestimo_id`)
    REFERENCES `bib`.`emprestimo` (`emprestimo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
