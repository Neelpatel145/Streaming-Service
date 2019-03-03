SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PineappleMusicSchema
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PineappleMusicSchema` ;

-- -----------------------------------------------------
-- Schema PineappleMusicSchema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PineappleMusicSchema` DEFAULT CHARACTER SET utf8 ;
USE `PineappleMusicSchema` ;

-- -----------------------------------------------------
-- Table `PineappleMusicSchema`.`Accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PineappleMusicSchema`.`Accounts` ;

CREATE TABLE IF NOT EXISTS `PineappleMusicSchema`.`Accounts` (
  `accountID` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `passwordResetCode` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`accountID`),
  UNIQUE INDEX `accountID_UNIQUE` (`accountID` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PineappleMusicSchema`.`Artist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PineappleMusicSchema`.`Artist` ;

CREATE TABLE IF NOT EXISTS `PineappleMusicSchema`.`Artist` (
  `acntID` INT NOT NULL,
  `stageName` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`acntID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PineappleMusicSchema`.`AccountFollowsArtist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PineappleMusicSchema`.`AccountFollowsArtist` ;

CREATE TABLE IF NOT EXISTS `PineappleMusicSchema`.`AccountFollowsArtist` (
  `acntID` INT NOT NULL,
  `artistID` INT NOT NULL,
  PRIMARY KEY (`acntID`, `artistID`),
  INDEX `fk_AccountFollowsArtist_Artist1_idx` (`artistID` ASC) VISIBLE,
  CONSTRAINT `fk_AccountFollowsArtist_Accounts`
    FOREIGN KEY (`acntID`)
    REFERENCES `PineappleMusicSchema`.`Accounts` (`accountID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AccountFollowsArtist_Artist1`
    FOREIGN KEY (`artistID`)
    REFERENCES `PineappleMusicSchema`.`Artist` (`acntID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PineappleMusicSchema`.`Songs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PineappleMusicSchema`.`Songs` ;

CREATE TABLE IF NOT EXISTS `PineappleMusicSchema`.`Songs` (
  `songID` INT NOT NULL,
  `filename` VARCHAR(45) NULL,
  PRIMARY KEY (`songID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PineappleMusicSchema`.`SongOwner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PineappleMusicSchema`.`SongOwner` ;

CREATE TABLE IF NOT EXISTS `PineappleMusicSchema`.`SongOwner` (
  `acntID` INT NOT NULL,
  `sID` INT NOT NULL,
  PRIMARY KEY (`acntID`, `sID`),
  INDEX `fk_SongOwner_Songs1_idx` (`sID` ASC) VISIBLE,
  CONSTRAINT `fk_SongOwner_Artist1`
    FOREIGN KEY (`acntID`)
    REFERENCES `PineappleMusicSchema`.`Artist` (`acntID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SongOwner_Songs1`
    FOREIGN KEY (`sID`)
    REFERENCES `PineappleMusicSchema`.`Songs` (`songID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PineappleMusicSchema`.`Playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PineappleMusicSchema`.`Playlist` ;

CREATE TABLE IF NOT EXISTS `PineappleMusicSchema`.`Playlist` (
  `playlistID` INT NOT NULL,
  `ownerID` INT NULL,
  `name` VARCHAR(45) NULL,
  `album` TINYINT NULL COMMENT 'if playlist is an album, all of the songs in the playlist must be owned by the owner of the playlist',
  `Accounts_accountID` INT NOT NULL,
  PRIMARY KEY (`playlistID`),
  INDEX `fk_Playlist_Accounts1_idx` (`ownerID` ASC) VISIBLE,
  CONSTRAINT `fk_Playlist_Accounts1`
    FOREIGN KEY (`ownerID`)
    REFERENCES `PineappleMusicSchema`.`Accounts` (`accountID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PineappleMusicSchema`.`Playlist_has_Songs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PineappleMusicSchema`.`Playlist_has_Songs` ;

CREATE TABLE IF NOT EXISTS `PineappleMusicSchema`.`Playlist_has_Songs` (
  `playlistID` INT NOT NULL,
  `songID` INT NOT NULL,
  PRIMARY KEY (`playlistID`, `songID`),
  INDEX `fk_Playlist_has_Songs_Songs1_idx` (`songID` ASC) VISIBLE,
  INDEX `fk_Playlist_has_Songs_Playlist1_idx` (`playlistID` ASC) VISIBLE,
  CONSTRAINT `fk_Playlist_has_Songs_Playlist1`
    FOREIGN KEY (`playlistID`)
    REFERENCES `PineappleMusicSchema`.`Playlist` (`playlistID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Playlist_has_Songs_Songs1`
    FOREIGN KEY (`songID`)
    REFERENCES `PineappleMusicSchema`.`Songs` (`songID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
