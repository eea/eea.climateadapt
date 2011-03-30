create table Ace_Project (
	projectId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	acronym VARCHAR(75) null,
	title VARCHAR(75) null,
	startdate DATE null,
	enddate DATE null,
	lead VARCHAR(75) null,
	partners VARCHAR(75) null,
	funding VARCHAR(75) null,
	sectors VARCHAR(75) null,
	spatiallevel VARCHAR(75) null,
	abstracts VARCHAR(75) null,
	element VARCHAR(75) null,
	keywords VARCHAR(75) null,
	website VARCHAR(75) null,
	duration VARCHAR(75) null
);