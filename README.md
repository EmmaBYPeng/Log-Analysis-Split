# Log-Analysis-Split
Rewrite of the splitting tool for log analysis

Inferring schema using reflection (automatically convert an RDD to a DataFrame):

- Since case classes in Scala 2.10 can support only up to 22 fields, we use custom classes that implements the Product interface

- RDD[A] can be implicitly converted to a DataFrame and then be registered as a table, given that A <: Product
