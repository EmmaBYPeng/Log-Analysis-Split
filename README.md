# Log-Analysis-Split
Rewrite of the splitting tool for log analysis (Spark-1.3.1)

Programmatically specifying the schema:

- Create an RDD of Rows from the original RDD;

- Create the schema represented by a StructType matching the structure of Rows in the RDD created in Step 1.

- Apply the schema to the RDD of Rows via createDataFrame method provided by SQLContext.
