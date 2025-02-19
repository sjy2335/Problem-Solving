SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME 
	FROM ANIMAL_INS AS I
    JOIN ANIMAL_OUTS AS O
    	ON I.ANIMAL_ID = O.ANIMAL_ID
    WHERE 
    	SUBSTRING_INDEX(I.SEX_UPON_INTAKE, ' ', 1) = 'Intact'
        AND SUBSTRING_INDEX(O.SEX_UPON_OUTCOME, ' ', 1) != 'Intact'
    ORDER BY I.ANIMAL_ID