package com.emma.Split

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql._

import com.emma.SQLModelFactory.Base
import com.emma.SQLModelFactory.AccountLogin

class SaveParquet[T <: Base](that: T) extends Serializable {
  var t: T = that
  
  def logToParquet(sqlContext: SQLContext, hadoopFile: RDD[(String, Array[String])], tableName: String, 
                   dst: String, gameId: String, accountType: String, worldId: String) = {
    try {
      val name = tableName
      
      val tempRDD = hadoopFile.filter {
        case (keyName, lineValues) => if (keyName.equalsIgnoreCase(name)) true else false  
      }
      
      val tempValues = tempRDD.map {
        case (key, values) => values
      }
      
      val schema = t.parseFromLogFile
      val rowRdd = tempValues.map { line => 
        val prefix = Array(gameId, accountType, worldId)
        val sum = prefix ++ line.tail
        Row.fromSeq(sum) 
      }
      val schemaRdd = sqlContext.createDataFrame(rowRdd, schema)
      
      schemaRdd.printSchema()
      
      println("BEGIN")
      println("Count: " + schemaRdd.count())
      schemaRdd.collect().foreach(println)
      println("END")
      
      schemaRdd.saveAsParquetFile(dst + "/" + tableName + ".parquet")
            
    } catch {
      case e: Throwable => e.printStackTrace()
    }
  }
}