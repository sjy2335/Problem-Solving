SELECT TRD.ID
FROM ECOLI_DATA TRD
JOIN (
	SELECT SND.ID, SND.PARENT_ID
    FROM ECOLI_DATA SND
    JOIN ECOLI_DATA FST
    	ON SND.PARENT_ID = FST.ID
    WHERE FST.PARENT_ID IS NULL
) AS SND
	ON TRD.PARENT_ID = SND.ID
ORDER BY TRD.ID;