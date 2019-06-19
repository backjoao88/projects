-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`venda` (
  `idvenda` INT NOT NULL,
  `data` DATE NULL,
  `dataVencimento` DATE NULL,
  `dataPagamento` DATE NULL,
  `cliente_idcliente` INT NOT NULL,
  `vendedor_idvendedor` INT NOT NULL,
  PRIMARY KEY (`idvenda`),
  INDEX `fk_venda_cliente_idx` (`cliente_idcliente` ASC),
  INDEX `fk_venda_vendedor1_idx` (`vendedor_idvendedor` ASC),
  CONSTRAINT `fk_venda_cliente`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `mydb`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_vendedor1`
    FOREIGN KEY (`vendedor_idvendedor`)
    REFERENCES `mydb`.`vendedor` (`idvendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `idcliente` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `rg` VARCHAR(45) NULL,
  `fone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `numero` INT NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vendedor` (
  `idvendedor` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  PRIMARY KEY (`idvendedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`marca` (
  `idmarca` INT NOT NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`idmarca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto` (
  `idproduto` INT NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `valor` DECIMAL(8,2) NULL,
  `estoque` INT NULL,
  `imagem` VARCHAR(100) NULL,
  `marca_idmarca` INT NOT NULL,
  PRIMARY KEY (`idproduto`),
  INDEX `fk_produto_marca1_idx` (`marca_idmarca` ASC),
  CONSTRAINT `fk_produto_marca1`
    FOREIGN KEY (`marca_idmarca`)
    REFERENCES `mydb`.`marca` (`idmarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`venda` (
  `idvenda` INT NOT NULL,
  `data` DATE NULL,
  `dataVencimento` DATE NULL,
  `dataPagamento` DATE NULL,
  `cliente_idcliente` INT NOT NULL,
  `vendedor_idvendedor` INT NOT NULL,
  PRIMARY KEY (`idvenda`),
  INDEX `fk_venda_cliente_idx` (`cliente_idcliente` ASC),
  INDEX `fk_venda_vendedor1_idx` (`vendedor_idvendedor` ASC),
  CONSTRAINT `fk_venda_cliente`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `mydb`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_vendedor1`
    FOREIGN KEY (`vendedor_idvendedor`)
    REFERENCES `mydb`.`vendedor` (`idvendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`produto_has_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto_has_venda` (
  `produto_idproduto` INT NOT NULL,
  `venda_idvenda` INT NOT NULL,
  `quantidadeProduto` INT NULL,
  PRIMARY KEY (`produto_idproduto`, `venda_idvenda`),
  INDEX `fk_produto_has_venda_venda1_idx` (`venda_idvenda` ASC),
  INDEX `fk_produto_has_venda_produto1_idx` (`produto_idproduto` ASC),
  CONSTRAINT `fk_produto_has_venda_produto1`
    FOREIGN KEY (`produto_idproduto`)
    REFERENCES `mydb`.`produto` (`idproduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_has_venda_venda1`
    FOREIGN KEY (`venda_idvenda`)
    REFERENCES `mydb`.`venda` (`idvenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
