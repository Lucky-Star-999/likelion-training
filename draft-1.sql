-- Full name: Nguyen Hoang Linh

-- Create table CAMPUS
CREATE TABLE CAMPUS (
	CampusID		VARCHAR2(5)		NOT NULL,
	CampusName		VARCHAR2(100),
	Street			VARCHAR2(100),
	City			VARCHAR2(100),
	State			VARCHAR2(100),
	Zip				VARCHAR2(100),
	Phone			VARCHAR2(100),
	CampusDiscount	DECIMAL(2,2),
	CONSTRAINT CAMPUS_PK PRIMARY KEY (CampusID)
)

-- Create table POSITION
CREATE TABLE POSITION (
	PositionID				VARCHAR2(5)		NOT NULL,
	POSITION				VARCHAR2(100),
	YearlyMembershipFee		DECIMAL(7,2),
	
	CONSTRAINT POSITION_PK PRIMARY KEY (PositionID)
)

-- Create table MEMBERS
CREATE TABLE MEMBERS (
	MemberID			VARCHAR2(5)		NOT NULL,
	LastName			VARCHAR2(100),
	FirstName			VARCHAR2(100),
	CampusAddress		VARCHAR2(100),
	CampusPhone			VARCHAR2(100),
	CampusID			VARCHAR2(5),
	PositionID			VARCHAR2(5),
	ContractDuration	INTEGER,
	
	CONSTRAINT MEMBERS_PK PRIMARY KEY (MemberID)
)

ALTER TABLE MEMBERS ADD CONSTRAINT CAMPUS_FK FOREIGN KEY(CampusID) REFERENCES CAMPUS(CampusID)
ALTER TABLE MEMBERS ADD CONSTRAINT POSITION_FK FOREIGN KEY(PositionID) REFERENCES POSITION(PositionID)


-- Create table PRICES
CREATE TABLE PRICES (
	FoodItemTypeID	NUMBER(20)		NOT NULL,
	MealType		VARCHAR2(100),
	MealPrice		DECIMAL(7,2),
	
	CONSTRAINT PRICES_PK PRIMARY KEY (FoodItemTypeID)
)

-- Create table FOODITEMS
CREATE TABLE FOODITEMS (
	FoodItemID		VARCHAR2(5)		NOT NULL,
	FoodItemName	VARCHAR2(100),
	FoodItemTypeID	NUMBER(20),
	
	CONSTRAINT FOODITEMS_PK PRIMARY KEY (FoodItemID)
)

ALTER TABLE FOODITEMS ADD CONSTRAINT PRICES_FK FOREIGN KEY (FoodItemTypeID) REFERENCES PRICES(FoodItemTypeID)

-- Create table ORDERS
CREATE TABLE ORDERS (
	OrderID		VARCHAR2(5)		NOT NULL,
	MemberID	VARCHAR2(5),
	OrderDate	VARCHAR2(25),
	
	CONSTRAINT ORDERS_PK PRIMARY KEY (OrderID)
)

ALTER TABLE ORDERS ADD CONSTRAINT MEMBERS_FK FOREIGN KEY (MemberID) REFERENCES MEMBERS(MemberID)

-- Create table ORDERLINE
CREATE TABLE ORDERLINE (
	OrderID			VARCHAR2(5)		NOT NULL,
	FoodItemsID		VARCHAR2(5)		NOT NULL,
	Quantity		NUMBER(20),
	
	CONSTRAINT ORDERLINE_PK PRIMARY KEY (OrderID, FoodItemsID)
)

ALTER TABLE ORDERLINE ADD CONSTRAINT ORDERS_FK FOREIGN KEY (OrderID) REFERENCES ORDERS(OrderID)
ALTER TABLE ORDERLINE ADD CONSTRAINT FOODITEMS_FK FOREIGN KEY (FoodItemsID) REFERENCES FOODITEMS(FoodItemID)

-- Create sequences
-- Prices_FoodItemTypeID_SEQ
CREATE SEQUENCE Prices_FoodItemTypeID_SEQ

-- Insert data
-- Insert data to CAMPUS
INSERT ALL
	INTO CAMPUS VALUES('1','IUPUI', '425 University Blvd.', 'Indianapolis', 'IN','46202', '317-274-4591',.08)
	INTO CAMPUS VALUES('2','Indiana University', '107 S. Indiana Ave.', 'Bloomington', 'IN','47405', '812-855-4848',.07)
	INTO CAMPUS VALUES('3','Purdue University', '475 Stadium Mall Drive', 'West Lafayette', 'IN', '47907', '765-494-1776',.06)
SELECT 1 FROM DUAL

-- Insert data to POSITION
INSERT ALL
	INTO POSITION VALUES('1', 'Lecturer', 1050.50)
	INTO POSITION VALUES('2', 'Associate Professor', 900.50)
	INTO POSITION VALUES('3', 'Assistant Professor', 875.50)
	INTO POSITION VALUES('4', 'Professor', 700.75)
	INTO POSITION VALUES('5', 'Full Professor', 500.50)
SELECT 1 FROM DUAL

-- Insert data to MEMBERS
INSERT ALL
	INTO MEMBERS VALUES('1', 'Ellen', 'Monk', '009 Purnell', '812-123-1234', '2', '5', 12)
	INTO MEMBERS VALUES('2', 'Joe', 'Brady', '008 Statford Hall', '765-234-2345', '3', '2', 10)
	INTO MEMBERS VALUES('3', 'Dave', 'Davidson', '007 Purnell', '812-345-3456', '2', '3', 10)
	INTO MEMBERS VALUES('4', 'Sebastian', 'Cole', '210 Rutherford Hall', '765-234-2345', '3', '5', 10)
	INTO MEMBERS VALUES('5', 'Michael', 'Doo', '66C Peobody', '812-548-8956', '2', '1', 10)
	INTO MEMBERS VALUES('6', 'Jerome', 'Clark', 'SL 220', '317-274-9766', '1', '1', 12)
	INTO MEMBERS VALUES('7', 'Bob', 'House', 'ET 329', '317-278-9098', '1', '4', 10)
	INTO MEMBERS VALUES('8', 'Bridget', 'Stanley','SI 234', '317-274-5678', '1', '1', 12)
	INTO MEMBERS VALUES('9', 'Bradley', 'Wilson', '334 Statford Hall', '765-258-2567', '3', '2', 10)
SELECT 1 FROM DUAL

-- Insert data to PRICES
INSERT INTO PRICES VALUES(PRICES_FOODITEMTYPEID_SEQ.Nextval, 'Beer/Wine', 5.50)
INSERT INTO PRICES VALUES(PRICES_FOODITEMTYPEID_SEQ.Nextval, 'Beer/Wine', 5.50)
INSERT INTO PRICES VALUES(PRICES_FOODITEMTYPEID_SEQ.Nextval, 'Dessert', 2.75)
INSERT INTO PRICES VALUES(PRICES_FOODITEMTYPEID_SEQ.Nextval, 'Dinner', 15.50)
INSERT INTO PRICES VALUES(PRICES_FOODITEMTYPEID_SEQ.Nextval, 'Soft Drink', 2.50)
INSERT INTO PRICES VALUES(PRICES_FOODITEMTYPEID_SEQ.Nextval, 'Lunch', 7.25)


-- Insert data to FOODITEMS
INSERT ALL
	INTO FOODITEMS VALUES('10001', 'Lager', '1')
	INTO FOODITEMS VALUES('10002', 'Red Wine', '1')
	INTO FOODITEMS VALUES('10003', 'White Wine', '1')
	INTO FOODITEMS VALUES('10004', 'Coke', '4')
	INTO FOODITEMS VALUES('10005', 'Coffee', '4')
	INTO FOODITEMS VALUES('10006', 'Chicken a la King', '3')
	INTO FOODITEMS VALUES('10007', 'Rib Steak', '3')
	INTO FOODITEMS VALUES('10008', 'Fish and Chips', '3')
	INTO FOODITEMS VALUES('10009', 'Veggie Delight', '3')
	INTO FOODITEMS VALUES('10010', 'Chocolate Mousse', '2')
	INTO FOODITEMS VALUES('10011', 'Carrot Cake', '2')
	INTO FOODITEMS VALUES('10012', 'Fruit Cup', '2')
	INTO FOODITEMS VALUES('10013', 'Fish and Chips', '5')
	INTO FOODITEMS VALUES('10014', 'Angus Beef Burger', '5')
	INTO FOODITEMS VALUES('10015', 'Cobb Salad', '5')
SELECT 1 FROM DUAL

-- Insert data to ORDERS
INSERT ALL
	INTO ORDERS VALUES('1', '9', 'March 5, 2005')
	INTO ORDERS VALUES('2', '8', 'March 5, 2005')
	INTO ORDERS VALUES('3', '7', 'March 5, 2005')
	INTO ORDERS VALUES('4', '6', 'March 7, 2005')
	INTO ORDERS VALUES('5', '5', 'March 7, 2005')
	INTO ORDERS VALUES('6', '4', 'March 10, 2005')
	INTO ORDERS VALUES('7', '3', 'March 11, 2005')
	INTO ORDERS VALUES('8', '2', 'March 12, 2005')
	INTO ORDERS VALUES('9', '1', 'March 13, 2005')
SELECT 1 FROM DUAL

-- Insert data to ORDERLINE
INSERT ALL
	INTO ORDERLINE VALUES('1','10001',1)
	INTO ORDERLINE VALUES('1','10006',1)
	INTO ORDERLINE VALUES('1','10012',1)
	INTO ORDERLINE VALUES('2','10004',2)
	INTO ORDERLINE VALUES('2','10013',1)
	INTO ORDERLINE VALUES('2','10014',1)
	INTO ORDERLINE VALUES('3','10005',1)
	INTO ORDERLINE VALUES('3','10011',1)
	INTO ORDERLINE VALUES('4','10005',2)
	INTO ORDERLINE VALUES('4','10004',2)
	INTO ORDERLINE VALUES('4','10006',1)
	INTO ORDERLINE VALUES('4','10007',1)
	INTO ORDERLINE VALUES('4','10010',2)
	INTO ORDERLINE VALUES('5','10003',1)
	INTO ORDERLINE VALUES('6','10002',2)
	INTO ORDERLINE VALUES('7','10005',2)
	INTO ORDERLINE VALUES('8','10005',1)
	INTO ORDERLINE VALUES('8','10011',1)
	INTO ORDERLINE VALUES('9','10001',1)
SELECT 1 FROM DUAL



-- Question 1: List all constraints in database
SELECT constraint_name, constraint_type FROM all_constraints
WHERE constraint_name NOT LIKE 'BIN$%' AND constraint_name NOT LIKE 'SYS_%'

-- Question 2: List all tables in database
SELECT OWNER, TABLE_NAME FROM all_tables

-- Question 3: List all sequences in database
SELECT SEQUENCE_NAME FROM all_sequences

-- Question 4:
SELECT
	MEMBERS.FIRSTNAME,
	MEMBERS.LASTNAME,
	POSITION.POSITION,
	CAMPUS.CAMPUSNAME,
	YEARLYMEMBERSHIPFEE/12 AS Monthly_Dues
FROM MEMBERS
JOIN POSITION ON POSITION.POSITIONID = MEMBERS.POSITIONID
JOIN CAMPUS ON CAMPUS.CAMPUSID = MEMBERS.CAMPUSID
ORDER BY CAMPUS.CAMPUSNAME DESC, MEMBERS.LASTNAME ASC;







