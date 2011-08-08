create table Ace_AceItem (
	aceItemId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	nasId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	datatype VARCHAR(75) null,
	storedAt VARCHAR(75) null,
	storagetype VARCHAR(75) null,
	language VARCHAR(75) null,
	textSearch VARCHAR(75) null,
	keyword VARCHAR(75) null,
	targetresolution VARCHAR(75) null,
	spatialLayer VARCHAR(75) null,
	spatialValues VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	publicationDate DATE null,
	sectors_ VARCHAR(75) null,
	elements_ VARCHAR(75) null,
	climateimpacts_ VARCHAR(75) null,
	rating LONG,
	importance LONG
);

create table Ace_NAS (
	nasId LONG not null primary key,
	name VARCHAR(75) null,
	adoptedStatus VARCHAR(75) null,
	adoptedDescription VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	parentNasId LONG,
	isoCountry VARCHAR(75) null
);

create table Ace_NASSource (
	nassourceid LONG not null primary key,
	nasId LONG,
	name VARCHAR(75) null,
	companyId LONG,
	groupId LONG
);