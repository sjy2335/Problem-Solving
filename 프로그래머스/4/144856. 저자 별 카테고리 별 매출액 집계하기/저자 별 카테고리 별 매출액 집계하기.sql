WITH TARGET_SALES AS (
	SELECT BOOK_ID, SUM(SALES) AS SALES
    FROM BOOK_SALES
    WHERE SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
    GROUP BY BOOK_ID
)

SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(T.SALES * B.PRICE) AS TOTAL_SALES
FROM BOOK AS B
JOIN AUTHOR AS A
	ON B.AUTHOR_ID = A.AUTHOR_ID
JOIN TARGET_SALES AS T
	ON T.BOOK_ID = B.BOOK_ID
GROUP BY
	A.AUTHOR_ID, B.CATEGORY
ORDER BY
	A.AUTHOR_ID, B.CATEGORY DESC