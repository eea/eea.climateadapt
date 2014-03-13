create table Ace_Project (
	projectId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	admincomment VARCHAR(75) null,
	acronym VARCHAR(75) null,
	title VARCHAR(75) null,
	startdate DATE null,
	enddate DATE null,
	lead VARCHAR(75) null,
	partners VARCHAR(75) null,
	funding VARCHAR(75) null,
	sectors VARCHAR(75) null,
	spatiallayer VARCHAR(75) null,
	abstracts VARCHAR(75) null,
	element VARCHAR(75) null,
	keywords VARCHAR(75) null,
	website VARCHAR(75) null,
	duration VARCHAR(75) null,
	rating LONG,
	importance LONG,
	specialtagging VARCHAR(75) null,
	controlstatus INTEGER,
	creator VARCHAR(75) null,
	creationdate DATE null,
	moderator VARCHAR(75) null,
	approvaldate DATE null,
	replacesId LONG,
	comments VARCHAR(75) null,
	textwebpage VARCHAR(75) null,
	spatialvalues VARCHAR(75) null,
	source VARCHAR(75) null,
	climateimpacts VARCHAR(75) null,
	lockdate DATE null,
	feature VARCHAR(75) null,
	supdocs VARCHAR(75) null,
	geochars VARCHAR(75) null
);