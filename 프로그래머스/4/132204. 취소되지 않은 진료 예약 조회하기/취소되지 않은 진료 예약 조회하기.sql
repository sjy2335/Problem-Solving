SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM APPOINTMENT AS A
JOIN DOCTOR AS D
	ON D.DR_ID = A.MDDR_ID
JOIN PATIENT AS P
	ON P.PT_NO = A.PT_NO
WHERE DATEDIFF(A.APNT_YMD, '2022-04-13') = 0 AND A.APNT_CNCL_YN != 'Y'
ORDER BY A.APNT_YMD;