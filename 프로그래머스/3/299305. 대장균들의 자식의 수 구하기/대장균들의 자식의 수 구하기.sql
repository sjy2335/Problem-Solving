# Using Sub-Query
# EXPLAIN ANALYZE
# SELECT 
# 	ID, 
# 	(SELECT COUNT(*)
#      FROM ECOLI_DATA 
#      WHERE PARENT_ID = E.ID) AS CHILD_COUNT
# FROM 
# 	ECOLI_DATA E
# ORDER BY 
# 	ID ASC;
    
# -> Sort: e.ID  (cost=0.85 rows=6) (actual time=0.0376..0.0378 rows=6 loops=1)
#     -> Table scan on E  (cost=0.85 rows=6) (actual time=0.0191..0.0243 rows=6 loops=1)
# -> Select #2 (subquery in projection; dependent)
#     -> Aggregate: count(0)  (cost=0.45 rows=1) (actual time=0.00427..0.00431 rows=1 loops=6)
#         -> Filter: (ecoli_data.PARENT_ID = e.ID)  (cost=0.35 rows=1) (actual time=0.0031..0.00366 rows=0.667 loops=6)
#             -> Table scan on ECOLI_DATA  (cost=0.35 rows=6) (actual time=935e-6..0.00307 rows=6 loops=6)


# Using Left-Join
# EXPLAIN ANALYZE
SELECT
	E.ID,
    (COUNT(C.ID)) AS CHILD_COUNT
FROM
	ECOLI_DATA E
LEFT JOIN
	ECOLI_DATA C
ON
	E.ID = C.PARENT_ID
GROUP BY
	E.ID
ORDER BY
	E.ID ASC;
    
# -> Sort: e.ID  (actual time=0.0744..0.0747 rows=6 loops=1)
#     -> Table scan on   (actual time=0.0631..0.0637 rows=6 loops=1)
#         -> Aggregate using temporary table  (actual time=0.0625..0.0625 rows=6 loops=1)
#             -> Left hash join (c.PARENT_ID = e.ID)  (cost=3.99 rows=36) (actual time=0.0378..0.0422 rows=7 loops=1)
#                 -> Table scan on E  (cost=0.85 rows=6) (actual time=0.00184..0.00492 rows=6 loops=1)
#                 -> Hash
#                     -> Table scan on C  (cost=0.142 rows=6) (actual time=0.0189..0.0239 rows=6 loops=1)