CREATE TABLE UserInfo(
	Id int AUTO_INCREMENT NOT NULL,
	Username varchar(64) NULL,
	AuthPwd varchar(255) NULL,
	GameId int NULL,
	CreatedDateTime datetime NULL,
	LastLoginDateTime datetime NULL,
    PRIMARY KEY (Id) 
);



CREATE TABLE UserConnectionInfo(
	Id int AUTO_INCREMENT NOT NULL,
	UserId int ,
	SessionId varchar(255) NULL,
	TokenId varchar(255) NULL,
	ConnectDateTime datetime NULL,
    FOREIGN KEY (UserId )REFERENCES UserInfo(Id),
PRIMARY KEY (Id)
);


INSERT INTO `businesssimulation`.`userinfo`
(
`Username`,
`AuthPwd`,
`GameId`,
`CreatedDateTime`,
`LastLoginDateTime`)
VALUES
('sid',
'system123#',
-1,
now(),
null);
