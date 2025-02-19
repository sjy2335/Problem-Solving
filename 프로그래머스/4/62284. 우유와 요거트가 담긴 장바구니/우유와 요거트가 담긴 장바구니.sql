SELECT DISTINCT CART_ID
FROM CART_PRODUCTS C1
WHERE EXISTS (
    SELECT 1
    FROM CART_PRODUCTS C2
    WHERE C1.CART_ID = C2.CART_ID AND C2.NAME = 'Milk'
) AND EXISTS (
    SELECT 1
    FROM CART_PRODUCTS C3
    WHERE C1.CART_ID = C3.CART_ID AND C3.NAME = 'Yogurt'
)
ORDER BY CART_ID;