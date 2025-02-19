SELECT F.CATEGORY, T.MAX_PRICE, F.PRODUCT_NAME
FROM FOOD_PRODUCT AS F
JOIN (
	SELECT MAX(PRICE) AS MAX_PRICE, CATEGORY
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY
) AS T
	ON F.CATEGORY = T.CATEGORY 
    AND F.PRICE = T.MAX_PRICE
ORDER BY T.MAX_PRICE DESC;