
CREATE OR REPLACE PROCEDURE TransferFunds (
    from_account IN NUMBER,
    to_account IN NUMBER,
    amount IN NUMBER
) IS
    source_balance NUMBER;
BEGIN
    SELECT Balance INTO source_balance
    FROM Accounts
    WHERE AccountID = from_account
    FOR UPDATE;

    IF source_balance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - amount
    WHERE AccountID = from_account;

    UPDATE Accounts
    SET Balance = Balance + amount
    WHERE AccountID = to_account;

    DBMS_OUTPUT.PUT_LINE('Transfer of ' || amount || ' completed from account ' ||
                         from_account || ' to account ' || to_account);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('One or both account IDs are invalid.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
