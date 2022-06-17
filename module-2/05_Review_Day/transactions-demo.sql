DROP TABLE IF EXISTS account;
CREATE TABLE account 
(
	account_id SERIAL PRIMARY KEY,
	balance INTEGER NOT NULL DEFAULT(0)
);

INSERT INTO account (balance) VALUES (100), (100); -- 2 accounts to start

-----------------------------

-- 1. An error will automatically rollback on commit.
START TRANSACTION;

COMMIT;

-- 2. Updates and Deletes will lock the rows they affect.
--    Selects and Inserts will release locks immediately.
START TRANSACTION;

COMMIT;

-- 3. Updates, Inserts, and Deletes can cause non-repeatable reads or phantom rows
-- when using READ COMMITTED isolation level.
START TRANSACTION;

COMMIT;

-- 4. REPEATABLE READ isolation level prevents phantom rows and non-repeatable reads.
--    Your view the data will not see changes committed by other transactions.
--    However, if you update or delete the same data your transaction will fail. 
START TRANSACTION;
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;

COMMIT;


-- 5. Manually locking is possible. There are many modes to this.
--    Postgres is smart enough to provide automatic locking that works in many scenarios.
--	  Avoid doing this unless you absolutely know you should. 
START TRANSACTION;
LOCK TABLE account IN ACCESS EXCLUSIVE MODE;

SELECT balance FROM account WHERE account_id = 1;

COMMIT;


-- 6. SERIALIZABLE transactions will fail if there is a cyclic dependency.
--	  To be considered as a dependent transaction, a transaction need to be serializable.
START TRANSACTION;
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

INSERT INTO account (balance) VALUES ((SELECT SUM(balance) FROM account)); -- sum all balances and insert new account with that result

COMMIT;

