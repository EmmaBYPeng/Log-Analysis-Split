package com.emma.SQLModelFactory

import org.apache.spark.sql.types._
import org.apache.spark.sql.Row

import java.sql.Timestamp

class AccountLogin extends Base {
  
  def parseFromLogFile: StructType = {
    
      return StructType(Array(StructField("GameId", LongType, true), StructField("AccountType", LongType, true), 
                              StructField("WorldId", LongType, true), StructField("dtEventTime", StringType, true), 
                              StructField("iEventId", StringType, true), StructField("vVersionId", StringType, true), 
                              StructField("vUin", StringType, true), StructField("vClientIp", StringType, true),
                              StructField("vZoneId", StringType, true), StructField("dtCreateTime", StringType, true), 
                              StructField("iFeeFlag", LongType, true), StructField("vLoginWay", StringType, true)))
                      
  }
  
  def toRow(line: Array[String]): Row = {
    
      val gameId = line(0).toLong
      val accountType = line(1).toLong
      val worldId = line(2).toLong
      val dtEventTime = line(3)
      val iEventId = line(4)
      val vVersionId = line(5)
      val vUin = line(6)
      val vClientIp = line(7)
      val vZoneId = line(8)
      val dtCreateTime = line(9)
      val iFeeFlag = line(10).toLong
      val vLoginWay = line(11)
      
      return Row(gameId, accountType, worldId, dtEventTime, iEventId, vVersionId, vUin, vClientIp, vZoneId, dtCreateTime, iFeeFlag, vLoginWay)
    
  }
}
