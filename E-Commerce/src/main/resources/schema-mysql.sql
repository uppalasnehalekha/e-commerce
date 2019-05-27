CREATE TABLE IF NOT EXISTS Items(
	itemId VARCHAR(36),
	itemName VARCHAR(36),
	itemCost INTEGER,
	quantity INTEGER,
	PRIMARY KEY(itemId)
);

CREATE TABLE IF NOT EXISTS Orders(
	id VARCHAR(36),
	itemsListDoc JSON,
	emailId VARCHAR(36),
	address VARCHAR(36),
	phoneNumber INTEGER,
	PRIMARY KEY(id)
);