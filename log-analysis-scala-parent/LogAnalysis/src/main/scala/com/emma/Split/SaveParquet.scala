package com.emma.Split

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.hive.HiveContext;
import org.apache.spark.rdd.RDD


import com.emma.SQLModelFactory.Base

class SaveParquet[T <: Base](that: T) {
  var t: T = that
  
  def logToParquet(sc: SparkContext, sqlContext: HiveContext, hadoopFile: RDD[(String, Array[String])], tableName: String, 
                   dst: String, gameId: String, accountType: String, worldId: String) = {
    try {
      val name = tableName
      
      val tempRDD = hadoopFile.filter {
        case (keyName, lineValues) => if (keyName.equalsIgnoreCase(name)) true else false  
      }
      
      val tempValues = tempRDD.map {
        case (key, values) => values
      }
      
      val tempLogs = tempValues.map { line => 
        t.parseFromLogFile(line, gameId, accountType, worldId)
      }
      
      val schemaRDD = sqlContext.createDataFrame(tempLogs, t.getClass)
      schemaRDD.printSchema()
      
      schemaRDD.saveAsParquetFile(dst + "/" + tableName + ".parquet")
    } catch {
      case e: Throwable => e.printStackTrace()
    }
  }
}