CREATE TABLE IF NOT EXISTS Items(
	itemId VARCHAR(36) NOT NULL,
	itemName VARCHAR(36) NOT NULL,
	itemCost INT(11) NOT NULL,
	quantity INT(11) NOT NULL ,
	PRIMARY KEY(itemId)
);

CREATE TABLE IF NOT EXISTS Orders(
	orderId VARCHAR(36) NOT NULL,
	itemsListDoc JSON,
	emailId VARCHAR(36),
	address VARCHAR(36),
	phoneNumber INTEGER,
	orderTime DATE,
	billingAmount FLOAT,
	PRIMARY KEY(orderId)
);